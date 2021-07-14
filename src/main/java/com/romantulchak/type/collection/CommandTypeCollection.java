package com.romantulchak.type.collection;

import com.romantulchak.type.impl.CommandType;

import java.util.List;

public class CommandTypeCollection<T> extends CommandType<T> {

    public CommandTypeCollection(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz) {
        super(stringBuilder, selectedArguments, clazz);
    }

    public CommandTypeCollection<T> distinct() {
        super.executeDistinct();
        return this;
    }

    public ConditionTypeCollection<T> from(String table) {
        super.executeFrom(table);
        return new ConditionTypeCollection<>(stringBuilder, selectedArguments, clazz, table);
    }

    public ConditionTypeCollection<T> from(Class<T> clazz) {
        super.executeFrom(clazz);
        return new ConditionTypeCollection<>(stringBuilder, selectedArguments, clazz, clazz.getSimpleName());
    }
}
