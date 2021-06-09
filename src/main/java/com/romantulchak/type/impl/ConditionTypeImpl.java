package com.romantulchak.type.impl;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.LINQ;
import com.romantulchak.linq.LinqManager;
import com.romantulchak.linq.Persistable;
import com.romantulchak.type.ConditionType;
import com.romantulchak.type.UnifyingType;

import java.util.List;

import static com.romantulchak.constants.LINQConstant.*;

public class ConditionTypeImpl<T extends Persistable> extends LinqManager<T> implements ConditionType<T>, LINQ<T> {

    private final StringBuilder stringBuilder;
    private final List<String> selectedArguments;

    public ConditionTypeImpl(StringBuilder stringBuilder, List<String> selectedArguments){
        this.stringBuilder = stringBuilder;
        this.selectedArguments = selectedArguments;
    }


    @Override
    public UnifyingType<T> where(String tableColumn, ComparisonConstant comparison, Object value) {
        stringBuilder.append(WHERE)
                .append(SPACE)
                .append(tableColumn)
                .append(getComparisonSymbol(comparison))
                .append("'")
                .append(value)
                .append("'");
        return new UnifyingTypeImpl<>(stringBuilder, selectedArguments);
    }


}
