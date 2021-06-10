package com.romantulchak.linq;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.type.Invoke;
import com.romantulchak.type.SelectiveType;
import com.romantulchak.type.impl.SelectiveTypeImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static com.romantulchak.constants.LINQConstant.SPACE;

public class LinqManager<T extends Persistable> implements Invoke<T> {
    protected StringBuilder stringBuilder = new StringBuilder();
    protected List<String> selectedArguments = new ArrayList<>();

    public T clazz;

    protected String getComparisonSymbol(ComparisonConstant comparison) {
        if (comparison != null) {
            return SPACE + comparison.getSymbol() + SPACE;
        }
        throw new RuntimeException("Comparison is null");
    }

    public T execute(T...classes) {
        initializeGenericClass(classes);
        LinqMapper<T> linqMapper = new LinqMapper<>(selectedArguments);
        return linqMapper.createObject(clazz, stringBuilder.toString()).orElseThrow();
    }

    @SafeVarargs
    @Override
    public final SelectiveType<T> linq(T... classes) {
        initializeGenericClass(classes);
        return new SelectiveTypeImpl<>(stringBuilder, clazz);
    }

    @SafeVarargs
    private void initializeGenericClass(T...classes){
        try {
            if (classes.getClass().getComponentType() != null) {
                this.clazz = (T) classes.getClass().getComponentType().getConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
