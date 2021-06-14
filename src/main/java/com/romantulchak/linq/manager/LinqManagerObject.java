package com.romantulchak.linq.manager;

import com.romantulchak.linq.mapper.LinqMapper;
import com.romantulchak.linq.LinqObject;
import com.romantulchak.type.object.SelectiveTypeObject;

import java.util.ArrayList;
import java.util.List;

public class LinqManagerObject<T>  implements LinqObject<T> {
    protected StringBuilder stringBuilder = new StringBuilder();
    protected List<String> selectedArguments = new ArrayList<>();
    protected Class<T> clazz;
    protected static Class<?> currentClass;

    @SafeVarargs
    public LinqManagerObject(T... classes) {
        if (currentClass == null) {
            currentClass = this.getClass();
        }
        clazz = initializeGenericClass(classes);
    }

    public SelectiveTypeObject<T> linq(){
        return new SelectiveTypeObject<>(stringBuilder, clazz);
    }

    @SafeVarargs
    @Override
    public final T execute(T... classes) {
        clazz = initializeGenericClass(classes);
        LinqMapper<T> linqMapper = new LinqMapper<>(selectedArguments, currentClass);
        return linqMapper.createObject(clazz, stringBuilder.toString()).orElse(null);
    }

    protected void setStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    protected void setSelectedArguments(List<String> selectedArguments) {
        this.selectedArguments = selectedArguments;
    }
}
