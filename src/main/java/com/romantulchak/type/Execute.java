package com.romantulchak.type;

public interface Execute<T> {
    T execute(Class<T> clazz);
}
