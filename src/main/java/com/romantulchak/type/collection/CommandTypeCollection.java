package com.romantulchak.type.collection;

import com.romantulchak.type.impl.CommandTypeImpl;
import com.romantulchak.type.object.CommandTypeObject;
import com.romantulchak.type.object.ConditionTypeObject;

import java.util.List;

public class CommandTypeCollection<T> extends CommandTypeImpl<T> {

    public CommandTypeCollection(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz) {
        super(stringBuilder, selectedArguments, clazz);
    }

    public CommandTypeCollection<T> distinct() {
        super.executeDistinct();
        return this;
    }

    public ConditionTypeCollection<T> from(String table) {
        super.executeFrom(table);
        return new ConditionTypeCollection<>(stringBuilder, selectedArguments, clazz);
    }

    public ConditionTypeCollection<T> from(Class<T> clazz) {
        super.executeFrom(clazz);
        return new ConditionTypeCollection<>(stringBuilder, selectedArguments, clazz);
    }
}
