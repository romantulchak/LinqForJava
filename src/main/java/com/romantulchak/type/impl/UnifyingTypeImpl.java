package com.romantulchak.type.impl;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.LINQ;
import com.romantulchak.linq.LinqManager;
import com.romantulchak.linq.Persistable;
import com.romantulchak.type.UnifyingType;

import java.util.List;

import static com.romantulchak.constants.LINQConstant.AND;

public class UnifyingTypeImpl<T extends Persistable> extends LinqManager<T> implements UnifyingType<T> {

    private final StringBuilder stringBuilder;
    private final List<String> selectedArguments;

    public UnifyingTypeImpl(StringBuilder stringBuilder, List<String> selectedArguments) {
        this.stringBuilder = stringBuilder;
        this.selectedArguments = selectedArguments;
    }

    @Override
    public UnifyingType<T> and(String tableColumn, ComparisonConstant comparison, Object value) {
        stringBuilder.append(AND)
                .append(tableColumn)
                .append(getComparisonSymbol(comparison))
                .append(value);
        return this;
    }

    @Override
    public T execute(Class<T> clazz) {
        super.stringBuilder = stringBuilder;
        super.selectedArguments = selectedArguments;
        return super.execute(clazz);
    }
}
