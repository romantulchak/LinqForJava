package com.romantulchak.type.collection;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.manager.LinqManagerCollection;
import com.romantulchak.type.impl.ConditionType;

import java.util.Collection;
import java.util.List;

import static com.romantulchak.util.ClassUtility.setExecuteValues;

public class ConditionTypeCollection<T> extends ConditionType<T> {
    public ConditionTypeCollection(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz, String table) {
        super(stringBuilder, selectedArguments, clazz, table);
    }

    public UnifyingTypeCollection<T> where(String tableColumn, ComparisonConstant comparison, Object value) {
        executeWhere(tableColumn, comparison, value);
        return new UnifyingTypeCollection<>(stringBuilder, selectedArguments, clazz);
    }

    @SafeVarargs
    public final Collection<T> execute(T... classes) {
        LinqManagerCollection<T> linqManagerCollection = new LinqManagerCollection<>();
        setExecuteValues(stringBuilder, "setStringBuilder", linqManagerCollection, StringBuilder.class);
        setExecuteValues(selectedArguments, "setSelectedArguments", linqManagerCollection, List.class);
        return linqManagerCollection.execute(classes);
    }
}
