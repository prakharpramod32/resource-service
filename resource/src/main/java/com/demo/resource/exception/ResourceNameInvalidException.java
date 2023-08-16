package com.demo.resource.exception;

public class ResourceNameInvalidException extends Exception {

    private String message;

    public ResourceNameInvalidException(String message) {
        super();
        this.message = message;
    }
}
