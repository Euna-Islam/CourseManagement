package com.euna.springboot.demo.error;

public class NoRecordFoundException extends RuntimeException{
    public NoRecordFoundException(String error) {
        super(error);
    }
}
