package com.romantulchak.type.impl;

import com.romantulchak.exception.ArgumentIsEmptyException;
import com.romantulchak.exception.UncorrectedNumberOfArgumentsException;
import com.romantulchak.linq.Persistable;
import com.romantulchak.model.Person;
import com.romantulchak.type.CommandType;
import com.romantulchak.type.SelectiveType;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.romantulchak.constants.LINQConstant.*;

public class SelectiveTypeImpl<T extends Persistable> implements SelectiveType<T> {
    private final StringBuilder stringBuilder;

    private final T clazz;

    //TODO: створювати тут об'єкт типу LinqMapper і перекидуавти його до низу без перекидання SelectedArguments
    private final List<String> selectedArguments;

    public SelectiveTypeImpl(StringBuilder stringBuilder, T clazz) {
        this.stringBuilder = stringBuilder;
        this.selectedArguments = new ArrayList<>();
        this.clazz = clazz;
    }

    public CommandType<T> select(String... args) {
        stringBuilder.append(SELECT)
                .append(SPACE);
        appendArguments(args);
        return new CommandTypeImpl<>(stringBuilder, selectedArguments, clazz);
    }

    @Override
    public CommandType<T> selectAll() {
        stringBuilder
                .append(SELECT)
                .append(SPACE);
        appendArguments(getClassFields());
        return new CommandTypeImpl<>(stringBuilder, selectedArguments, clazz);
    }

    private void appendArguments(String... args) {
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                if (!StringUtils.isBlank(args[i])) {
                    stringBuilder.append(args[i]);
                    selectedArguments.add(args[i]);
                    if (i != args.length - 1) {
                        stringBuilder.append(COMA);
                    }
                } else {
                    throw new ArgumentIsEmptyException(SELECT);
                }
            }
        } else {
            throw new UncorrectedNumberOfArgumentsException(SELECT);
        }
    }

    private String[] getClassFields() {
        Field[] declaredFields = clazz.getClass().getDeclaredFields();
        if (declaredFields.length != 0) {
            return Arrays.stream(declaredFields)
                    .map(Field::getName)
                    .toArray(String[]::new);
        }
        return new String[]{};
    }



}
