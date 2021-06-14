package com.romantulchak.type.object;

import com.romantulchak.type.impl.CommandTypeImpl;

import java.util.List;

public class CommandTypeObject<T> extends CommandTypeImpl<T> {

    public CommandTypeObject(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz) {
        super(stringBuilder, selectedArguments, clazz);
    }

    public CommandTypeObject<T> distinct() {
        super.executeDistinct();
        return this;
    }

    public ConditionTypeObject<T> from(String table) {
        super.executeFrom(table);
        return new ConditionTypeObject<>(stringBuilder, selectedArguments, clazz);
    }

    public ConditionTypeObject<T> from(Class<T> clazz) {
        super.executeFrom(clazz);
        return new ConditionTypeObject<>(stringBuilder, selectedArguments, clazz);
    }



}
