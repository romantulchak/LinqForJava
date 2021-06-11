package com.romantulchak.linq;

import com.romantulchak.type.Invoke;
import com.romantulchak.type.SelectiveType;
import com.romantulchak.type.impl.SelectiveTypeImpl;

import java.util.ArrayList;
import java.util.List;

public abstract class Manager<T> implements Invoke<T> {
    protected StringBuilder stringBuilder = new StringBuilder();
    protected List<String> selectedArguments = new ArrayList<>();
    protected Class<T> clazz;
    protected static Class<?> currentClass;
    protected T execute(T... classes) {
        clazz = initializeGenericClass(classes);
        LinqMapper<T> linqMapper = new LinqMapper<>(selectedArguments, currentClass);
        return linqMapper.createObject(clazz, stringBuilder.toString()).orElseThrow();
    }

    @Override
    public SelectiveType<T> linq(T... classes) {
        initializeGenericClass(classes);
        return new SelectiveTypeImpl<>(stringBuilder, clazz);
    }

    @SafeVarargs
    protected final Class<T>  initializeGenericClass(T... classes){
        if(classes != null) {
            return (Class<T>) classes.getClass().getComponentType();
        }
        throw new RuntimeException("Class not found");
    }
}
