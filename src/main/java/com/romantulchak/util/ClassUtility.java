package com.romantulchak.util;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.Persistable;
import com.romantulchak.linq.manager.LinqManagerObject;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static com.romantulchak.constants.LINQConstant.SPACE;

public class ClassUtility {

    //TODO: update this method

    public static String[] getClassFields(Class<?> clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        if (declaredFields.length != 0) {
            return Arrays.stream(declaredFields)
                    .map(ClassUtility::getSerializable)
                    .toArray(String[]::new);
        }
        return new String[]{};
    }

    private static Serializable getSerializable(Field field) {
        field.getClass().isAssignableFrom(Persistable.class);
        return field.getName();
    }

    public static String getComparisonSymbol(ComparisonConstant comparison) {
        if (comparison != null) {
            return SPACE + comparison.getSymbol() + SPACE;
        }
        throw new RuntimeException("Comparison is null");
    }

    public static void setExecuteValues(Object objectToSet,String methodName ,Object object, Class<?>... args){
        try {
            Method method = object.getClass().getDeclaredMethod(methodName, args);
            method.setAccessible(true);
            method.invoke(object, objectToSet);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void addQuotesToString(StringBuilder stringBuilder, Object value){
        if(value instanceof String || value instanceof Character){
            stringBuilder.append("'")
                    .append(value)
                    .append("'");
        }else {
            stringBuilder.append(value);
        }
    }
}
