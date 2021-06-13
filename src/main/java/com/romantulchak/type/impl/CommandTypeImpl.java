package com.romantulchak.type.impl;

import com.romantulchak.type.CommandType;
import com.romantulchak.type.ConditionType;

import java.util.List;

import static com.romantulchak.constants.LINQConstant.*;

public class CommandTypeImpl<T> {
    protected final StringBuilder stringBuilder;
    protected final List<String> selectedArguments;
    protected final Class<T> clazz;

    public CommandTypeImpl(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz) {
        this.stringBuilder = stringBuilder;
        this.selectedArguments = selectedArguments;
        this.clazz = clazz;
    }

    protected CommandTypeImpl<T> executeDistinct() {
        stringBuilder.insert(7, DISTINCT + SPACE);
        return this;
    }

    protected ConditionTypeImpl<T> executeFrom(String table) {
        stringBuilder.append(FROM)
                .append(SPACE)
                .append(table);
        return new ConditionTypeImpl<>(stringBuilder, selectedArguments, clazz);
    }

    protected ConditionTypeImpl<T> executeFrom(Class<T> clazz) {
        if (clazz != null) {
            stringBuilder
                    .append(FROM)
                    .append(SPACE)
                    .append(clazz.getSimpleName());
            return new ConditionTypeImpl<>(stringBuilder, selectedArguments, clazz);
        }
        throw new RuntimeException("Class is null");
    }

}
