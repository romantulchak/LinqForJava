package com.romantulchak.linq.mapper;

import com.romantulchak.db.DatabaseConnection;
import com.romantulchak.exception.CannotCreateInstanceOfClass;
import com.romantulchak.exception.NotUniqueElementException;
import com.romantulchak.linq.Persistable;
import com.romantulchak.linq.manager.LinqManagerObject;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.stream.Stream;

public class LinqMapper<T> {
    private final List<String> selectedArguments;
    private final Class<?> executorClass;
    private final Connection connection;
    public LinqMapper(List<String> selectedArguments, Class<?> executorClass) {
        this.selectedArguments = selectedArguments;
        this.executorClass = executorClass;
        connection = DatabaseConnection.getInstance().getConnection();

    }

    public Optional<T> createObject(Class<T> clazz, String query) {
        ResultSet resultSet = getResultSet(query).orElseThrow(() -> new RuntimeException("Result set is null"));
        try {
            if(resultSet.first()){
                T object = getObjectFromClass(clazz).orElseThrow(() -> new CannotCreateInstanceOfClass(clazz.getSimpleName()));
                initializeObject(resultSet, object);
                return Optional.of(object);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    private Optional<T> getObjectFromClass(Class<T> clazz) {
        try {
            return Optional.of(clazz.getConstructor().newInstance());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Collection<T> createObjects(Class<T> clazz, String query) {
        ResultSet resultSet = getResultSet(query).orElseThrow(() -> new RuntimeException("Result set is null"));
        Collection<T> objects = new ArrayList<>();
        try {
            while (resultSet.next()) {
                T object = getObjectFromClass(clazz).orElseThrow(() -> new CannotCreateInstanceOfClass(clazz.getSimpleName()));
                initializeObject(resultSet, object);
                objects.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objects;
    }

    private Optional<ResultSet> getResultSet(String query) {
        if (!StringUtils.isBlank(query)) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.last();
                int row = resultSet.getRow();
                if (row != 1 && executorClass.equals(LinqManagerObject.class)) {
                    throw new NotUniqueElementException(row);
                }
                resultSet.beforeFirst();
                return Optional.of(resultSet);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return Optional.empty();
    }

    private void initializeObject(ResultSet resultSet, T object) {
        List<Field> fields = new LinkedList<>(Arrays.asList(object.getClass().getDeclaredFields()));
        fields = getOnlySelectedFields(fields);
        for (Field field : fields) {
            try {
                getDataFromResultSet(resultSet, object, field);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Field> getOnlySelectedFields(List<Field> fields) {
        List<Field> fieldsToReturn = new ArrayList<>();
        for (String argument : selectedArguments) {
            for (Field field : fields) {
                if (field.getName().equals(argument)) {
                    fieldsToReturn.add(field);
                }
            }
        }
        return fieldsToReturn;
    }

    private void getDataFromResultSet(ResultSet resultSet, T object, Field field) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException {
            Method method;
            if (field.getType().equals(Integer.class)) {
                method = ResultSet.class.getDeclaredMethod("getInt", String.class);
            } else {
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
