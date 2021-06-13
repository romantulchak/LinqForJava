package com.romantulchak.type.collection;

import com.romantulchak.type.impl.SelectiveTypeImpl;

public class SelectiveTypeCollection<T> extends SelectiveTypeImpl<T> {
    public SelectiveTypeCollection(StringBuilder stringBuilder, Class<T> clazz) {
        super(stringBuilder, clazz);
    }



}
