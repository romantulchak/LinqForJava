package com.romantulchak.linq;

import com.romantulchak.db.DatabaseConnection;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class LinqMapper<T extends Persistable> {
    private final List<String> selectedArguments;

    public LinqMapper(List<String> selectedArguments){
        this.selectedArguments = selectedArguments;
    }

    public Optional<T> createObject(T clazz, String query) {
        DatabaseConnection instance = DatabaseConnection.getInstance();
        try {
            Statement statement = instance.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            T object = (T) clazz.getClass().getConstructor().newInstance();
            initializeObject(resultSet, object);
            return Optional.of(object);

        } catch (SQLException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    private void initializeObject(ResultSet resultSet, T object) throws SQLException, IllegalAccessException {
        while (resultSet.next()) {
            List<Field> fields = new LinkedList<>(Arrays.asList(object.getClass().getDeclaredFields()));
            fields = getOnlySelectedFields(fields);
            LinqMapper<T> linqMapper = new LinqMapper<>(selectedArguments);
            for (Field field : fields) {
                try {
                    getDataFromResultSet(resultSet, object, field);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private List<Field> getOnlySelectedFields(List<Field> fields) {
        List<Field> fieldsToReturn = new ArrayList<>();
        for (String argument : selectedArguments) {
            for (Field field : fields) {
                if(field.getName().equals(argument)){
                    fieldsToReturn.add(field);
                }
            }
        }
        return fieldsToReturn;
    }

    private void getDataFromResultSet(ResultSet resultSet, Persistable object, Field field) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method;
        if(field.getType().equals(Integer.class)){
            method = ResultSet.class.getDeclaredMethod("getInt", String.class);
        }else {
            method = ResultSet.class.getDeclaredMethod("get" + StringUtils.capitalize(field.getType().getSimpleName()), String.class);
        }
        Object result = method.invoke(resultSet, field.getName());
        field.setAccessible(true);
        field.set(object, result);
    }


    private <E> void setData(Persistable t, Field field, E data) throws IllegalAccessException {
        field.setAccessible(true);
        field.set(t, data);
    }

}
