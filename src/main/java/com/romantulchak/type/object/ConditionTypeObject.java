package com.romantulchak.type.object;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.LinqMapper;
import com.romantulchak.linq.LinqObject;
import com.romantulchak.linq.manager.LinqManagerObject;
import com.romantulchak.type.ConditionType;
import com.romantulchak.type.UnifyingType;
import com.romantulchak.type.impl.ConditionTypeImpl;
import com.romantulchak.type.impl.UnifyingTypeImpl;
import com.romantulchak.type.impl.UnifyingTypeObject;

import java.util.List;

import static com.romantulchak.constants.LINQConstant.SPACE;
import static com.romantulchak.constants.LINQConstant.WHERE;
import static com.romantulchak.util.ClassUtility.getComparisonSymbol;

public class ConditionTypeObject<T> extends ConditionTypeImpl<T> {

    public ConditionTypeObject(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz) {
        super(stringBuilder, selectedArguments, clazz);
    }

    public UnifyingTypeObject<T> where(String tableColumn, ComparisonConstant comparison, Object value) {
        executeWhere(tableColumn, comparison, value);
        return new UnifyingTypeObject<>(stringBuilder, selectedArguments, clazz);
    }


//    @SafeVarargs
//    @Override
//    public final T execute(T... classes) {
//        super.stringBuilder = stringBuilder;
//        super.selectedArguments = selectedArguments;
//        return super.execute(classes);
//    }

    @SafeVarargs
    public final T execute(T... classes) {
        LinqManagerObject<T> linqManagerObject = new LinqManagerObject<>();
        linqManagerObject.setStringBuilder(stringBuilder);
        linqManagerObject.setSelectedArguments(selectedArguments);
        return linqManagerObject.execute(classes);
    }

}
