package com.romantulchak.linq.manager;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.Manager;

import static com.romantulchak.constants.LINQConstant.SPACE;

public class LinqManagerObject<T> extends Manager<T> {

    @SafeVarargs
    public LinqManagerObject(T... classes) {
        if (currentClass == null) {
            currentClass = this.getClass();
        }
        super.clazz = initializeGenericClass(classes);
    }

    protected String getComparisonSymbol(ComparisonConstant comparison) {
        if (comparison != null) {
            return SPACE + comparison.getSymbol() + SPACE;
        }
        throw new RuntimeException("Comparison is null");
    }

}
