package com.romantulchak.exception;

public class UncorrectedNumberOfArgumentsException extends RuntimeException{
    public UncorrectedNumberOfArgumentsException(String section){
        super(String.format("Number of arguments in section %s isn't correct", section));
    }
}
