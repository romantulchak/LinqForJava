package com.romantulchak.type.object;

import com.romantulchak.type.impl.SelectiveTypeImpl;

public class SelectiveTypeObject<T> extends SelectiveTypeImpl<T> {


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
