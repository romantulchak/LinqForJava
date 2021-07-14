package com.romantulchak.type.object;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.LinqObject;
import com.romantulchak.linq.manager.LinqManagerObject;
import com.romantulchak.type.impl.ConditionType;

import java.util.List;

import static com.romantulchak.util.ClassUtility.setExecuteValues;

public class ConditionTypeObject<T> extends ConditionType<T> implements LinqObject<T>{

    public ConditionTypeObject(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz, String table) {
        super(stringBuilder, selectedArguments, clazz, table);
    }

    public UnifyingTypeObject<T> where(String tableColumn, ComparisonConstant comparison, Object value) {
        executeWhere(tableColumn, comparison, value);
        return new UnifyingTypeObject<>(stringBuilder, selectedArguments, clazz);
    }
    public ConditionTypeObject<T> leftJoin(String tableToJoin, String tableField, String secondTableField) {
        executeLeftJoin(tableToJoin, tableField, secondTableField);
        return new ConditionTypeObject<>(stringBuilder, selectedArguments, clazz, table);
    }


    @SafeVarargs
    public final T execute(T... classes) {
        LinqManagerObject<T> linqManagerObject = new LinqManagerObject<>();
        setExecuteValues(stringBuilder, "setStringBuilder", linqManagerObject, StringBuilder.class);
        setExecuteValues(selectedArguments, "setSelectedArguments", linqManagerObject, List.class);
        return linqManagerObject.execute(classes);
    }


}
