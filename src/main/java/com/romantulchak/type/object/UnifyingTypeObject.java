package com.romantulchak.type.object;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.LinqObject;
import com.romantulchak.linq.manager.LinqManagerObject;
import com.romantulchak.type.impl.UnifyingTypeImpl;

import java.util.List;

import static com.romantulchak.util.ClassUtility.setExecuteValues;

public class UnifyingTypeObject<T> extends UnifyingTypeImpl<T> implements LinqObject<T> {
    public UnifyingTypeObject(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz) {
        super(stringBuilder, selectedArguments, clazz);
    }

    @Override
    public UnifyingTypeObject<T> and(String tableColumn, ComparisonConstant comparison, Object value) {
        super.and(tableColumn, comparison, value);
        return this;
    }


    @Override
    public UnifyingTypeObject<T> or(String tableColumn, ComparisonConstant comparison, Object value) {
        super.or(tableColumn, comparison, value);
        return this;
    }

    @SafeVarargs
    @Override
    public final T execute(T... classes) {
        LinqManagerObject<T> linqManagerObject = new LinqManagerObject<>();
        setExecuteValues(stringBuilder, "setStringBuilder", linqManagerObject, StringBuilder.class);
        setExecuteValues(selectedArguments, "setSelectedArguments", linqManagerObject, List.class);
        return linqManagerObject.execute(classes);
    }

}
