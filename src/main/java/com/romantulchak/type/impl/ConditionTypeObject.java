package com.romantulchak.type.impl;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.LINQ;
import com.romantulchak.linq.manager.LinqManagerObject;
import com.romantulchak.type.ConditionType;
import com.romantulchak.type.UnifyingType;

import java.util.List;

import static com.romantulchak.constants.LINQConstant.*;

public class ConditionTypeObject<T> extends LinqManagerObject<T> implements ConditionType<T>, LINQ<T> {

    private final StringBuilder stringBuilder;
    private final List<String> selectedArguments;
    private final Class<T> clazz;

    public ConditionTypeObject(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz) {
        this.stringBuilder = stringBuilder;
        this.selectedArguments = selectedArguments;
        this.clazz = clazz;
    }


    @Override
    public UnifyingType<T> where(String tableColumn, ComparisonConstant comparison, Object value) {
        stringBuilder.append(WHERE)
                .append(SPACE)
                .append(tableColumn)
                .append(getComparisonSymbol(comparison))
                .append("'")
                .append(value)
                .append("'");
        return new UnifyingTypeObject<>(stringBuilder, selectedArguments, clazz);
    }


    @SafeVarargs
    @Override
    public final T execute(T... classes) {
        super.stringBuilder = stringBuilder;
        super.selectedArguments = selectedArguments;
        return super.execute(classes);
    }
}
