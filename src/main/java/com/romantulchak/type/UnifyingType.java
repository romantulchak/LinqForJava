package com.romantulchak.type;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.LINQ;

public interface UnifyingType<T> {
    UnifyingType<T> and(String tableColumn, ComparisonConstant comparisonConstant, Object value);

    LINQ<T> ok();
}
