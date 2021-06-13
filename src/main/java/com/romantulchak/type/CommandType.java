package com.romantulchak.type;


public interface CommandType<T> {
    CommandType<T> executeDistinct();

    ConditionType<T> executeFrom(Class<?> clazz);

    ConditionType<T> executeFrom(String table);
}
