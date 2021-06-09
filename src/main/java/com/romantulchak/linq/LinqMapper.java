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

    public Optional<T> createObject(Class<T> clazz, String query) {
        DatabaseConnection instance = DatabaseConnection.getInstance();
        try {
            Statement statement = instance.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            T object = clazz.getConstructor().newInstance();
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
//                    Method method = LinqMapper.class.getDeclaredMethod("get" + StringUtils.capitalize(field.getType().getSimpleName()) + "Data", ResultSet.class, Persistable.class, field.getClass());
//                    method.invoke(linqMapper, resultSet, object, field);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private List<Field> getOnlySelectedFields(List<Field> fields) {
        List<Field> fieldsToReturn = new ArrayList<>();
        for (String s : selectedArguments) {
            for (Field field : fields) {
                if(field.getName().equals(s)){
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

    private void getStringData(ResultSet resultSet, Persistable object, Field field) throws SQLException, IllegalAccessException {
        String data = resultSet.getString(field.getName());
        setData(object, field, data);
    }

    private void getIntegerData(ResultSet resultSet, Persistable object, Field field) throws SQLException, IllegalAccessException {
        int data = resultSet.getInt(field.getName());
        setData(object, field, data);
    }

    private void getLongData(ResultSet resultSet, Persistable object, Field field) throws SQLException, IllegalAccessException {
        long data = resultSet.getLong(field.getName());
        setData(object, field, data);
    }

    private void getBooleanData(ResultSet resultSet, Persistable object, Field field) throws SQLException, IllegalAccessException {
        boolean data = resultSet.getBoolean(field.getName());
        setData(object, field, data);
    }

    private void getByteData(ResultSet resultSet, Persistable object, Field field) throws SQLException, IllegalAccessException {
        byte data = resultSet.getByte(field.getName());
        setData(object, field, data);
    }

    private void getShortData(ResultSet resultSet, Persistable object, Field field) throws SQLException, IllegalAccessException {
        short data = resultSet.getShort(field.getName());
        setData(object, field, data);
    }

    private <E> void setData(Persistable t, Field field, E data) throws IllegalAccessException {
        field.setAccessible(true);
        field.set(t, data);
    }

}
