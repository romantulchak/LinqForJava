package com.romantulchak.type.object;

import com.romantulchak.type.CommandType;
import com.romantulchak.type.ConditionType;
import com.romantulchak.type.impl.CommandTypeImpl;
import com.romantulchak.type.impl.ConditionTypeImpl;

import java.util.List;
import java.util.Map;

import static com.romantulchak.constants.LINQConstant.*;
import static com.romantulchak.constants.LINQConstant.SPACE;

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
