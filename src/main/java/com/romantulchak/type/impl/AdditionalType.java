package com.romantulchak.type.impl;

import java.util.List;

public class AdditionalType<T> {
    protected final StringBuilder stringBuilder;
    protected final List<String> selectedArguments;
    protected final Class<T> clazz;

    public AdditionalType(StringBuilder stringBuilder, List<String> selectedArguments, Class<T> clazz) {
        this.stringBuilder = stringBuilder;
        this.selectedArguments = selectedArguments;
        this.clazz = clazz;
    }

}
