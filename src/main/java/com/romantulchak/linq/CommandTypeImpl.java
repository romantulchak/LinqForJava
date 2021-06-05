package com.romantulchak.linq;

import com.romantulchak.type.CommandType;
import com.romantulchak.type.ConditionType;

import static com.romantulchak.constants.LINQConstant.*;

public class CommandTypeImpl<T> extends LinqManager<T> implements CommandType<T>, LINQ<T> {
    private final StringBuilder stringBuilder;

    public CommandTypeImpl(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
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
        return new ConditionTypeImpl<>(stringBuilder);
    }

    @Override
    public ConditionType<T> from(Class<?> clazz) {
        if (clazz != null) {
            stringBuilder
                    .append(FROM)
                    .append(SPACE)
                    .append(clazz.getSimpleName());
            return new ConditionTypeImpl<>(stringBuilder);
        }
        throw new RuntimeException("Class is null");
    }
}
