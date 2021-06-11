package com.romantulchak.util;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ClassUtility {

    public static String[] getClassFields(Class<?> clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        if (declaredFields.length != 0) {
            return Arrays.stream(declaredFields)
                    .map(Field::getName)
                    .toArray(String[]::new);
        }
        return new String[]{};
    }
}
