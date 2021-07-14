package com.romantulchak.type.impl;

import java.util.List;

import static com.romantulchak.constants.LINQConstant.*;

public class CommandType<T> {
    protected final StringBuilder stringBuilder;
    protected final List<String> selectedArguments;
    protected final Class<T> clazz;

    public CommandType(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz) {
        this.stringBuilder = stringBuilder;
        this.selectedArguments = selectedArguments;
        this.clazz = clazz;
    }

    protected CommandType<T> executeDistinct() {
        stringBuilder.insert(7, DISTINCT + SPACE);
        return this;
    }

    protected ConditionType<T> executeFrom(String table) {
        stringBuilder.append(FROM)
                .append(SPACE)
                .append(table)
                .append(SPACE)
                .append(table, 0, 2);
        return new ConditionType<>(stringBuilder, selectedArguments, clazz, table);
    }

    protected ConditionType<T> executeFrom(Class<T> clazz) {
        if (clazz != null) {
            stringBuilder
                    .append(FROM)
                    .append(SPACE)
                    .append(clazz.getSimpleName())
                    .append(SPACE)
                    .append(clazz.getSimpleName(), 0, 2);
            return new ConditionType<>(stringBuilder, selectedArguments, clazz, clazz.getSimpleName());
        }
        throw new RuntimeException("Class is null");
    }

}
