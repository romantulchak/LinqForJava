package com.romantulchak.type;

import com.romantulchak.enums.ComparisonConstant;

public interface ConditionType<T> extends Execute<T>{
    UnifyingType<T> where(String tableColumn, ComparisonConstant comparison, Object value);
}
