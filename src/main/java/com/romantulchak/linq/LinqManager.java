package com.romantulchak.linq;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.type.Invoke;
import com.romantulchak.type.SelectiveType;
import com.romantulchak.type.impl.SelectiveTypeImpl;

import java.util.ArrayList;
import java.util.List;

import static com.romantulchak.constants.LINQConstant.SPACE;

public class LinqManager<T extends Persistable> implements Invoke<T> {
    protected StringBuilder stringBuilder = new StringBuilder();
    protected List<String> selectedArguments = new ArrayList<>();
//
//    @Override
//    public SelectiveType<T> select(String... args) {
//        stringBuilder.append(SELECT);
//        appendArguments(args);
//        return this;
//    }
//
//    @Override
//    public SelectiveType<T> selectAll() {
//        stringBuilder
//                .append(SELECT)
//                .append("*");
//        return this;
//    }
//
//    @Override
//    public SelectiveType<T> distinct() {
//        stringBuilder.insert(6,DISTINCT);
//        return this;
//    }
//
//    @Override
//    public ConditionType<T> from(String table) {
//        stringBuilder.append(FROM).append(table);
//        return this;
//    }
//
//    @Override
//    public ConditionType<T> from(Class<?> clazz) {
//        if (clazz != null) {
//            stringBuilder
//                    .append(FROM)
//                    .append(clazz.getSimpleName());
//            return this;
//        }
//        throw new RuntimeException("Class is null");
//    }
//
//    @Override
//    public UnifyingType<T> where(String tableColumn, ComparisonConstant comparison, Object value) {
//        stringBuilder.append(WHERE)
//                .append(tableColumn)
//                .append(getComparisonSymbol(comparison))
//                .append(value);
//        return this;
//    }
//
//
//
//    @Override
//    public UnifyingType<T> and(String tableColumn, ComparisonConstant comparison, Object value) {
//        stringBuilder.append(AND)
//                .append(tableColumn)
//                .append(getComparisonSymbol(comparison))
//                .append(value);
//        return this;
//    }
//
//    private String getComparisonSymbol(ComparisonConstant comparison) {
//        if (comparison != null) {
//            return SPACE + comparison.getSymbol() + SPACE;
//        }
//        throw new RuntimeException("Comparison is null");
//    }
//
//    private void appendArguments(String section, String... args) {
//        if(args.length != 0) {
//            stringBuilder.append(section);
//            for (String arg : args) {
//                stringBuilder.append(arg)
//                        .append(SPACE);
//            }
//        }else {
//            throw new UncorrectedNumberOfArgumentsException(section);
//        }
//    }
//
//    private void appendArguments(String... args){
//        if (args.length != 0){
//            for (int i = 0; i < args.length; i++) {
//                stringBuilder.append(args[i]);
//                if(i != args.length - 1){
//                    stringBuilder.append(COMA);
//                }
//            }
//
//        }else {
//            throw new UncorrectedNumberOfArgumentsException(SELECT);
//        }
//    }
//
//    private void checkArguments(String section, Object... args) {
//        if (args.length == 0) {
//            throw new UncorrectedNumberOfArgumentsException(section.trim());
//        }
//    }
//
//    @Override
//    public LINQ<T> ok() {
//        return this;
//    }
//
    protected String getComparisonSymbol(ComparisonConstant comparison) {
        if (comparison != null) {
            return SPACE + comparison.getSymbol() + SPACE;
        }
        throw new RuntimeException("Comparison is null");
    }

    public T execute(Class<T> clazz) {
        LinqMapper<T> linqMapper = new LinqMapper<>(selectedArguments);
        return linqMapper.createObject(clazz, stringBuilder.toString()).orElseThrow();
    }

    @Override
    public SelectiveType<T> linq() {
        return new SelectiveTypeImpl<>(stringBuilder);
    }
}
