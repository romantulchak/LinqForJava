package com.romantulchak.type.impl;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.type.UnifyingType;

import java.util.List;

import static com.romantulchak.constants.LINQConstant.*;
import static com.romantulchak.util.ClassUtility.addQuotesToString;
import static com.romantulchak.util.ClassUtility.getComparisonSymbol;

public class UnifyingTypeImpl<T> implements UnifyingType<T>{

    protected final StringBuilder stringBuilder;
    protected final List<String> selectedArguments;
    protected final Class<T> clazz;

    public UnifyingTypeImpl(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz) {
        this.stringBuilder = stringBuilder;
        this.selectedArguments = selectedArguments;
        this.clazz = clazz;
    }

    @Override
    public UnifyingType<T> and(String tableColumn, ComparisonConstant comparison, Object value) {
        getAppend(tableColumn, comparison, value, AND);
        return this;
    }

    @Override
    public UnifyingType<T> or(String tableColumn, ComparisonConstant comparisonConstant, Object value) {
        getAppend(tableColumn, comparisonConstant, value, OR);
        return this;
    }

    private void getAppend(String tableColumn, ComparisonConstant comparisonConstant, Object value, String command) {
        stringBuilder.append(command)
                .append(SPACE)
                .append(tableColumn)
                .append(getComparisonSymbol(comparisonConstant));
        addQuotesToString(stringBuilder, value);
    }
}
