package com.romantulchak.type;

public interface SelectiveType<T> {
    CommandType<T> select(String... fields);

    CommandType<T> selectAll();

}
