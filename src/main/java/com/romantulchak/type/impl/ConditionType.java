package com.romantulchak.type.impl;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.util.ClassUtility;

import java.util.List;

import static com.romantulchak.constants.LINQConstant.*;
import static com.romantulchak.util.ClassUtility.getComparisonSymbol;
import static com.romantulchak.enums.ComparisonConstant.*;

public class ConditionType<T>{

    protected final StringBuilder stringBuilder;
    protected final List<String> selectedArguments;
    protected final Class<T> clazz;
    protected final String table;

    public ConditionType(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz, String table) {
        this.stringBuilder = stringBuilder;
        this.selectedArguments = selectedArguments;
        this.clazz = clazz;
        this.table = table;
    }


    protected void executeWhere(String tableColumn, ComparisonConstant comparison, Object value) {
        stringBuilder
                .append(WHERE)
                .append(SPACE)
                .append(table, 0, 2)
                .append(DOT.getSymbol())
                .append(tableColumn)
                .append(getComparisonSymbol(comparison));
        ClassUtility.addQuotesToString(stringBuilder, value);
    }

    protected void executeLeftJoin(String tableToJoin, String tableField, String secondTableField){
        stringBuilder.append(LEFT)
                .append(JOIN)
                .append(SPACE)
                .append(tableToJoin)
                .append(ON)
                .append(SPACE)
                .append(table, 0, 2)
                .append(DOT.getSymbol())
                .append(tableField)
                .append(SPACE)
                .append(EQUAL.getSymbol())
                .append(SPACE)
                .append(tableToJoin)
                .append(DOT.getSymbol())
                .append(secondTableField);
    }
}
