package com.romantulchak.type;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.LinqObject;

public interface UnifyingType<T> {
    UnifyingType<T> and(String tableColumn, ComparisonConstant comparisonConstant, Object value);
    UnifyingType<T> or(String tableColumn, ComparisonConstant comparisonConstant, Object value);
}
