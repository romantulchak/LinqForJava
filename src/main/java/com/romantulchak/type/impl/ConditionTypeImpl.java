package com.romantulchak.type.impl;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.util.ClassUtility;

import java.util.List;

import static com.romantulchak.constants.LINQConstant.*;
import static com.romantulchak.util.ClassUtility.getComparisonSymbol;

public class ConditionTypeImpl<T>{

    protected final StringBuilder stringBuilder;
    protected final List<String> selectedArguments;
    protected final Class<T> clazz;

    public ConditionTypeImpl(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz) {
        this.stringBuilder = stringBuilder;
        this.selectedArguments = selectedArguments;
        this.clazz = clazz;
    }


    protected void executeWhere(String tableColumn, ComparisonConstant comparison, Object value) {
        stringBuilder.append(WHERE)
                .append(SPACE)
                .append(tableColumn)
                .append(getComparisonSymbol(comparison));
        ClassUtility.addQuotesToString(stringBuilder, value);
    }
}
