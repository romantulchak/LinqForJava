package com.romantulchak.linq;


import java.util.Collection;

public interface LinqObject<T> extends Linq<T>{
    T execute(T... classes);
}
