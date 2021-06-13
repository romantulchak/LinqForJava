package com.romantulchak.exception;

public class CannotCreateInstanceOfClass extends RuntimeException{
    public CannotCreateInstanceOfClass(String className){
        super(String.format("Cannot create instance of class %s", className));
    }
}
