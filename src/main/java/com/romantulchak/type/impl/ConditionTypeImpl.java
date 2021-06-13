package com.romantulchak.type.impl;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.LinqObject;
import com.romantulchak.linq.manager.LinqManagerObject;
import com.romantulchak.type.ConditionType;
import com.romantulchak.type.UnifyingType;

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
                .append(getComparisonSymbol(comparison))
                .append("'")
                .append(value)
                .append("'");
    }




}
