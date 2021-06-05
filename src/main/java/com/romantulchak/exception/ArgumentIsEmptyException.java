package com.romantulchak.exception;

public class ArgumentIsEmptyException extends RuntimeException{

    public ArgumentIsEmptyException(String section){
        super(String.format("One of arguments in section %s is empty", section));
    }

}
