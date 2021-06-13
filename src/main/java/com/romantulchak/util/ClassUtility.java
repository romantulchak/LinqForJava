package com.romantulchak.util;

import com.romantulchak.enums.ComparisonConstant;

import java.lang.reflect.Field;
import java.util.Arrays;

import static com.romantulchak.constants.LINQConstant.SPACE;

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

    public static String getComparisonSymbol(ComparisonConstant comparison) {
        if (comparison != null) {
            return SPACE + comparison.getSymbol() + SPACE;
        }
        throw new RuntimeException("Comparison is null");
    }
}
