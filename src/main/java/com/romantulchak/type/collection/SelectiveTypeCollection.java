package com.romantulchak.type.collection;

import com.romantulchak.type.impl.SelectiveType;

public class SelectiveTypeCollection<T> extends SelectiveType<T> {
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
