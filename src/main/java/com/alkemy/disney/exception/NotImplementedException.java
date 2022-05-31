package com.alkemy.disney.exception;

import org.aspectj.weaver.ast.Not;

public class NotImplementedException extends RuntimeException{
    private static final String message = "The function is not implemented.";
    public NotImplementedException(){
        super(message);
    }
}
