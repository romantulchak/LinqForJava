package com.romantulchak.linq;

public interface Linq<T> {
    default Class<T>  initializeGenericClass(T... classes){
        if(classes != null) {
            return (Class<T>) classes.getClass().getComponentType();
        }
        throw new RuntimeException("Class not found");
    }
}
