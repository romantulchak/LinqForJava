package com.romantulchak.type;

public interface SelectiveType<T>{
    CommandType<T> select(String... args);
    CommandType<T> selectAll();

}
