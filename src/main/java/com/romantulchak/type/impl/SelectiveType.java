package com.romantulchak.type.impl;

import com.romantulchak.exception.ArgumentIsEmptyException;
import com.romantulchak.exception.UncorrectedNumberOfArgumentsException;
import com.romantulchak.util.ClassUtility;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.romantulchak.constants.LINQConstant.*;

public class SelectiveType<T> {
    protected final StringBuilder stringBuilder;

    protected final Class<T> clazz;

    //TODO: створювати тут об'єкт типу LinqMapper і перекидуавти його до низу без перекидання SelectedArguments
    protected final List<String> selectedArguments;

    public SelectiveType(StringBuilder stringBuilder, Class<T> clazz) {
        this.stringBuilder = stringBuilder;
        this.selectedArguments = new ArrayList<>();
        this.clazz = clazz;
    }

    protected void executeSelect(String... args) {
        stringBuilder.append(SELECT)
                .append(SPACE);
        appendArguments(args);
    }

    protected void executeSelectAll() {
        stringBuilder.append(SELECT)
                .append(SPACE);
        appendArguments(ClassUtility.getClassFields(clazz));
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


}
