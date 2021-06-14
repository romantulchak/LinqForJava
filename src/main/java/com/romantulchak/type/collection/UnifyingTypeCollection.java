package com.romantulchak.type.collection;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.manager.LinqManagerObject;
import com.romantulchak.type.impl.UnifyingTypeImpl;
import com.romantulchak.type.object.UnifyingTypeObject;

import java.util.List;

import static com.romantulchak.util.ClassUtility.setExecuteValues;

public class UnifyingTypeCollection<T> extends UnifyingTypeImpl<T> {
    public UnifyingTypeCollection(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz) {
        super(stringBuilder, selectedArguments, clazz);
    }

    @SafeVarargs
    public final T execute(T... classes) {
        LinqManagerObject<T> linqManagerObject = new LinqManagerObject<>();
        setExecuteValues(stringBuilder, "setStringBuilder", linqManagerObject, StringBuilder.class);
        setExecuteValues(selectedArguments, "setSelectedArguments", linqManagerObject, List.class);
        return linqManagerObject.execute(classes);
    }


    @Override
    public UnifyingTypeCollection<T> and(String tableColumn, ComparisonConstant comparison, Object value) {
        super.and(tableColumn, comparison, value);
        return this;
    }
    public UnifyingTypeCollection<T> or(String tableColumn, ComparisonConstant comparison, Object value) {
        super.or(tableColumn, comparison, value);
        return this;
    }
}
