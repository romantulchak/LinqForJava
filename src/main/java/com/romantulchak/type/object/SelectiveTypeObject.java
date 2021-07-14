package com.romantulchak.type.object;

import com.romantulchak.type.impl.SelectiveType;

public class SelectiveTypeObject<T> extends SelectiveType<T> {


    public SelectiveTypeObject(StringBuilder stringBuilder, Class<T> clazz) {
        super(stringBuilder, clazz);
    }

    public CommandTypeObject<T> select(String... args) {
        super.executeSelect(args);
        return new CommandTypeObject<>(super.stringBuilder, super.selectedArguments, super.clazz);
    }

    public CommandTypeObject<T> selectAll() {
        super.executeSelectAll();
        return new CommandTypeObject<>(super.stringBuilder, super.selectedArguments, super.clazz);
    }


}
