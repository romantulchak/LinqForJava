package com.romantulchak.type.impl;

import com.romantulchak.exception.ArgumentIsEmptyException;
import com.romantulchak.exception.UncorrectedNumberOfArgumentsException;
import com.romantulchak.linq.LinqManager;
import com.romantulchak.linq.Persistable;
import com.romantulchak.type.CommandType;
import com.romantulchak.type.SelectiveType;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.romantulchak.constants.LINQConstant.*;

public class SelectiveTypeImpl<T extends Persistable> implements SelectiveType<T> {
    private final StringBuilder stringBuilder;

    //TODO: створювати тут об'єкт типу LinqMapper і перекидуавти його до низу без перекидання SelectedArguments
    private final List<String> selectedArguments;
    public SelectiveTypeImpl(StringBuilder stringBuilder){
        this.stringBuilder = stringBuilder;
        this.selectedArguments = new ArrayList<>();
    }

    public CommandType<T> select(String... args) {
        stringBuilder.append(SELECT)
                     .append(SPACE);
        appendArguments(args);
        return new CommandTypeImpl<>(stringBuilder, selectedArguments);
    }

    @Override
    public CommandType<T> selectAll() {
        stringBuilder
                .append(SELECT)
                .append(SPACE)
                .append("*");
        return new CommandTypeImpl<>(stringBuilder, selectedArguments);
    }

    private void appendArguments(String... args) {
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                if(!StringUtils.isBlank(args[i])) {
                    stringBuilder.append(args[i]);
                    selectedArguments.add(args[i]);
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
}
