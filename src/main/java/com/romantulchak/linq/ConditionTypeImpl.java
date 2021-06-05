package com.romantulchak.linq;

import com.romantulchak.constants.LINQConstant;
import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.type.ConditionType;
import com.romantulchak.type.UnifyingType;

import static com.romantulchak.constants.LINQConstant.*;

public class ConditionTypeImpl<T> extends LinqManager<T> implements ConditionType<T>, LINQ<T> {

    private final StringBuilder stringBuilder;

    public ConditionTypeImpl(StringBuilder stringBuilder){
        this.stringBuilder = stringBuilder;
    }


    @Override
    public UnifyingType<T> where(String tableColumn, ComparisonConstant comparison, Object value) {
        stringBuilder.append(WHERE)
                .append(SPACE)
                .append(tableColumn)
                .append(getComparisonSymbol(comparison))
                .append(value);
        return new UnifyingTypeImpl<>(stringBuilder);
    }


}
