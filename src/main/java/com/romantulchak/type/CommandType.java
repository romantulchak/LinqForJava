package com.romantulchak.type;


public interface CommandType<T> {
    CommandType<T> distinct();
    ConditionType<T> from(Class<?> clazz);
    ConditionType<T> from(String table);
}
