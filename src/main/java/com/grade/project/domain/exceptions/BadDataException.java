package com.grade.project.domain.exceptions;

public class BadDataException extends RuntimeException{

    public BadDataException(String message) {
        super(message);
    }
}
