package com.romantulchak.type.object;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.LinqObject;
import com.romantulchak.linq.manager.LinqManagerObject;
import com.romantulchak.type.impl.ConditionTypeImpl;

import java.util.List;

import static com.romantulchak.util.ClassUtility.setExecuteValues;

public class ConditionTypeObject<T> extends ConditionTypeImpl<T> implements LinqObject<T>{

    public ConditionTypeObject(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz) {
        super(stringBuilder, selectedArguments, clazz);
    }

    public UnifyingTypeObject<T> where(String tableColumn, ComparisonConstant comparison, Object value) {
        executeWhere(tableColumn, comparison, value);
        return new UnifyingTypeObject<>(stringBuilder, selectedArguments, clazz);
    }

    @SafeVarargs
    public final T execute(T... classes) {
        LinqManagerObject<T> linqManagerObject = new LinqManagerObject<>();
        setExecuteValues(stringBuilder, "setStringBuilder", linqManagerObject, StringBuilder.class);
        setExecuteValues(selectedArguments, "setSelectedArguments", linqManagerObject, List.class);
        return linqManagerObject.execute(classes);
    }

}
