package com.romantulchak.linq.manager;

import com.romantulchak.linq.LinqCollection;
import com.romantulchak.linq.mapper.LinqMapper;
import com.romantulchak.type.collection.SelectiveTypeCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class LinqManagerCollection<T> implements LinqCollection<T> {
    protected StringBuilder stringBuilder = new StringBuilder();
    protected List<String> selectedArguments = new ArrayList<>();
    protected Class<T> clazz;
    protected static Class<?> currentClass;

    @SafeVarargs
    public LinqManagerCollection(T... classes) {
        if (currentClass == null) {
            currentClass = this.getClass();
        }
        clazz = initializeGenericClass(classes);
    }
    public SelectiveTypeCollection<T> linq(){
        return new SelectiveTypeCollection<>(stringBuilder, clazz);
    }

    @SafeVarargs
    @Override
    public final Collection<T> execute(T... classes) {
        clazz = initializeGenericClass(classes);
        LinqMapper<T> linqMapper = new LinqMapper<>(selectedArguments, currentClass);
        return linqMapper.createObjects(clazz, stringBuilder.toString());
    }

    protected void setStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    protected void setSelectedArguments(List<String> selectedArguments) {
        this.selectedArguments = selectedArguments;
    }
}
