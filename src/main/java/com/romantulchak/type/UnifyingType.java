package com.romantulchak.type;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.LINQ;

public interface UnifyingType<T> extends LINQ<T> {
    UnifyingType<T> and(String tableColumn, ComparisonConstant comparisonConstant, Object value);

}
