package com.romantulchak.type;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.LINQ;

public interface ConditionType<T> extends LINQ<T> {
    UnifyingType<T> where(String tableColumn, ComparisonConstant comparison, Object value);
}
