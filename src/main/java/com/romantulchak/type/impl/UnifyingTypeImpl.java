package com.romantulchak.type.impl;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.Linq;
import com.romantulchak.linq.LinqCollection;
import com.romantulchak.linq.LinqObject;
import com.romantulchak.linq.Manager;
import com.romantulchak.type.UnifyingType;
import com.romantulchak.util.ClassUtility;

import java.util.List;

import static com.romantulchak.constants.LINQConstant.AND;
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
        stringBuilder.append(AND)
                .append(tableColumn)
                .append(getComparisonSymbol(comparison))
                .append(value);
        return this;
    }

}
