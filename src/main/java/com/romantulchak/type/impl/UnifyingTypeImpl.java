package com.romantulchak.type.impl;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.LINQ;
import com.romantulchak.linq.LinqManager;
import com.romantulchak.type.UnifyingType;

import static com.romantulchak.constants.LINQConstant.AND;

public class UnifyingTypeImpl<T> extends LinqManager<T> implements UnifyingType<T> {

    private final StringBuilder stringBuilder;

    public UnifyingTypeImpl(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
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
    public LINQ<T> ok() {
        return () -> {
            System.out.println(stringBuilder);
            return stringBuilder.toString();
        };
    }
}
