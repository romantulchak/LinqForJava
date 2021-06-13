package com.romantulchak.type.impl;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.LinqObject;
import com.romantulchak.linq.Manager;
import com.romantulchak.linq.manager.LinqManagerObject;
import com.romantulchak.type.UnifyingType;

import java.util.Collection;
import java.util.List;

import static com.romantulchak.constants.LINQConstant.AND;

public class UnifyingTypeObject<T> extends UnifyingTypeImpl<T> implements LinqObject<T> {
    public UnifyingTypeObject(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz) {
        super(stringBuilder, selectedArguments, clazz);
    }

    @Override
    public T execute(T... classes) {
        LinqManagerObject<T> linqManagerObject = new LinqManagerObject<>();
        linqManagerObject.setStringBuilder(stringBuilder);
        linqManagerObject.setSelectedArguments(selectedArguments);
        return linqManagerObject.execute(classes);
    }


//
//    private final StringBuilder stringBuilder;
//    private final List<String> selectedArguments;
//    private final Class<T> clazz;
//
//    public UnifyingTypeObject(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz) {
//        this.stringBuilder = stringBuilder;
//        this.selectedArguments = selectedArguments;
//        this.clazz = clazz;
//    }
//
//    @Override
//    public UnifyingType<T> and(String tableColumn, ComparisonConstant comparison, Object value) {
//        stringBuilder.append(AND)
//                .append(tableColumn)
//                .append(getComparisonSymbol(comparison))
//                .append(value);
//        return this;
//    }

//    @SafeVarargs
//    @Override
//    public final T execute(T... classes) {
//        super.stringBuilder = stringBuilder;
//        super.selectedArguments = selectedArguments;
//        return super.execute(classes);
//    }



}
