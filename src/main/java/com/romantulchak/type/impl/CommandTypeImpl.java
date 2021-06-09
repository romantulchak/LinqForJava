package com.romantulchak.type.impl;

import com.romantulchak.linq.LINQ;
import com.romantulchak.linq.LinqManager;
import com.romantulchak.linq.Persistable;
import com.romantulchak.type.CommandType;
import com.romantulchak.type.ConditionType;

import java.util.List;

import static com.romantulchak.constants.LINQConstant.*;

public class CommandTypeImpl<T extends Persistable> extends LinqManager<T> implements CommandType<T>, LINQ<T> {
    private final StringBuilder stringBuilder;
    private final List<String> selectedArguments;
    public CommandTypeImpl(StringBuilder stringBuilder, List<String> selectedArguments) {
        this.stringBuilder = stringBuilder;
        this.selectedArguments = selectedArguments;
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
        return new ConditionTypeImpl<>(stringBuilder, selectedArguments);
    }

    @Override
    public ConditionType<T> from(Class<?> clazz) {
        if (clazz != null) {
            stringBuilder
                    .append(FROM)
                    .append(SPACE)
                    .append(clazz.getSimpleName());
            return new ConditionTypeImpl<>(stringBuilder, selectedArguments);
        }
        throw new RuntimeException("Class is null");
    }
}
