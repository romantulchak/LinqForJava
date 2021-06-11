package com.romantulchak.exception;

import com.romantulchak.linq.manager.LinqManagerCollection;
import com.romantulchak.linq.manager.LinqManagerObject;

public class NotUniqueElementException extends RuntimeException {
    public NotUniqueElementException(int numberOfElements) {
        super(String.format("Expected 1 element but was found %s elements, pleas use %s object instead of %s object",
                numberOfElements,
                LinqManagerCollection.class.getSimpleName(),
                LinqManagerObject.class.getSimpleName()
        ));
    }
}
