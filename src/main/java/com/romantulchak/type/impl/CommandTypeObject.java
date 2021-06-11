package com.romantulchak.type.impl;

import com.romantulchak.linq.LINQ;
import com.romantulchak.linq.Manager;
import com.romantulchak.linq.manager.LinqManagerObject;
import com.romantulchak.type.CommandType;
import com.romantulchak.type.ConditionType;
import com.romantulchak.type.SelectiveType;

import java.util.List;

import static com.romantulchak.constants.LINQConstant.*;

public class CommandTypeObject<T> extends Manager<T> implements CommandType<T> {
    private final StringBuilder stringBuilder;
    private final List<String> selectedArguments;
    private final Class<T> clazz;

    public CommandTypeObject(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz) {
        this.stringBuilder = stringBuilder;
        this.selectedArguments = selectedArguments;
        this.clazz = clazz;
    }

    @Override
    public CommandType<T> distinct() {
        stringBuilder.insert(7, DISTINCT + SPACE);
        return this;
    }

    @Override
    public ConditionType<T> from(String table) {
        stringBuilder.append(FROM)
                .append(SPACE)
                .append(table);
        return new ConditionTypeObject<>(stringBuilder, selectedArguments, clazz);
    }

    @Override
    public ConditionType<T> from(Class<?> clazz) {
        if (clazz != null) {
            stringBuilder
                    .append(FROM)
                    .append(SPACE)
                    .append(clazz.getSimpleName());
            return new ConditionTypeObject<>(stringBuilder, selectedArguments, this.clazz);
        }
        throw new RuntimeException("Class is null");
    }

}
