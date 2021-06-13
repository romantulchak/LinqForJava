package com.romantulchak.type;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.LinqObject;

public interface ConditionType<T> extends LinqObject<T> {
    void executeWhere(String tableColumn, ComparisonConstant comparison, Object value);
}
