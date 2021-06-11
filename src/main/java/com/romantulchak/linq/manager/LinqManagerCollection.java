package com.romantulchak.linq.manager;

import com.romantulchak.linq.Manager;
import com.romantulchak.type.SelectiveType;

import java.util.Collection;

public class LinqManagerCollection<T> extends Manager<T> {
    protected Collection<T> objects;


    @SafeVarargs
    public LinqManagerCollection(T... classes) {
        if (currentClass == null) {
            currentClass = this.getClass();
        }
        super.clazz = initializeGenericClass(classes);
    }

    @Override
    public SelectiveType<T> linq(T... classes) {
        return null;
    }
}
