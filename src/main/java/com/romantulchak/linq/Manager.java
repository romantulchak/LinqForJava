package com.romantulchak.linq;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.manager.LinqManagerCollection;
import com.romantulchak.linq.manager.LinqManagerObject;
import com.romantulchak.type.Invoke;
import com.romantulchak.type.SelectiveType;
import com.romantulchak.type.impl.SelectiveTypeImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.romantulchak.constants.LINQConstant.SPACE;

public abstract class Manager<T>{
//    protected StringBuilder stringBuilder = new StringBuilder();
//    protected List<String> selectedArguments = new ArrayList<>();
//    protected Class<T> clazz;
//    protected static Class<?> currentClass;

//    protected T execute(T... classes){
//        LinqMapper<T> linqMapper = new LinqMapper<>(selectedArguments, currentClass);
//        return linqMapper.createObject(clazz, stringBuilder.toString()).orElseThrow();
//    }
//
//    protected Collection<T> execute(){
//        LinqMapper<T> linqMapper = new LinqMapper<>(selectedArguments, currentClass);
//        return linqMapper.createObjects(clazz, stringBuilder.toString());
//    }
//
//    public Linq linq(T... classes){
//        if(currentClass.equals(LinqManagerObject.class)){
//            return new LinqManagerObject<>().linq(classes);
//        }else if(currentClass.equals(LinqManagerCollection.class)){
//            return new LinqManagerCollection<>().linq(classes);
//        }
//        throw new RuntimeException("Type not found");
//    }

//    protected SelectiveType<T> linqExecute(T... classes) {
//        initializeGenericClass(classes);
//        return new SelectiveTypeImpl<>(stringBuilder, clazz);
//    }






}
