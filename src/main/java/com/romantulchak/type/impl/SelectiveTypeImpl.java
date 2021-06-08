package com.romantulchak.type.impl;

import com.romantulchak.exception.ArgumentIsEmptyException;
import com.romantulchak.exception.UncorrectedNumberOfArgumentsException;
import com.romantulchak.type.CommandType;
import com.romantulchak.type.SelectiveType;
import org.apache.commons.lang3.StringUtils;

import static com.romantulchak.constants.LINQConstant.*;

public class SelectiveTypeImpl<T> implements SelectiveType<T> {
    private final StringBuilder stringBuilder;

    public SelectiveTypeImpl(StringBuilder stringBuilder){
        this.stringBuilder = stringBuilder;
    }

    public CommandType<T> select(String... args) {
        stringBuilder.append(SELECT)
                     .append(SPACE);
        appendArguments(args);
        return new CommandTypeImpl<>(stringBuilder);
    }

    @Override
    public CommandType<T> selectAll() {
        stringBuilder
                .append(SELECT)
                .append(SPACE)
                .append("*");
        return new CommandTypeImpl<>(stringBuilder);
    }

    private void appendArguments(String... args) {
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                if(!StringUtils.isBlank(args[i])) {
                    stringBuilder.append(args[i]);
                    if (i != args.length - 1) {
                        stringBuilder.append(COMA);
                    }
                }else{
                    throw new ArgumentIsEmptyException(SELECT);
                }
            }
        } else {
            throw new UncorrectedNumberOfArgumentsException(SELECT);
        }
    }

    public StringBuilder getSb() {
        return stringBuilder;
    }
}
