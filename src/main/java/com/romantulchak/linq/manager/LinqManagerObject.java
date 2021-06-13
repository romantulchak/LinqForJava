package com.romantulchak.linq.manager;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.Linq;
import com.romantulchak.linq.LinqMapper;
import com.romantulchak.linq.LinqObject;
import com.romantulchak.linq.Manager;
import com.romantulchak.type.object.SelectiveTypeObject;

import java.util.ArrayList;
import java.util.List;

import static com.romantulchak.constants.LINQConstant.SPACE;

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
        return linqMapper.createObject(clazz, stringBuilder.toString()).orElseThrow();
    }

    public void setStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public void setSelectedArguments(List<String> selectedArguments) {
        this.selectedArguments = selectedArguments;
    }
}
