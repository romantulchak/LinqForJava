package com.romantulchak.exception;

public class CannotReadFileException extends RuntimeException {
    public CannotReadFileException(String filename) {
        super(String.format("File %s cannot be read", filename));
    }
}
