package com.romantulchak.type.collection;

import com.romantulchak.type.impl.SelectiveTypeImpl;
import com.romantulchak.type.object.CommandTypeObject;

public class SelectiveTypeCollection<T> extends SelectiveTypeImpl<T> {
    public SelectiveTypeCollection(StringBuilder stringBuilder, Class<T> clazz) {
        super(stringBuilder, clazz);
    }

    public CommandTypeCollection<T> select(String... args) {
        super.executeSelect(args);
        return new CommandTypeCollection<>(super.stringBuilder, super.selectedArguments, super.clazz);
    }

    public CommandTypeCollection<T> selectAll() {
        super.executeSelectAll();
        return new CommandTypeCollection<>(super.stringBuilder, super.selectedArguments, super.clazz);
    }


}
