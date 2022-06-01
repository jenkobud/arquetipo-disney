package com.alkemy.disney.exception;

public class NotFoundOnDataBaseException extends RuntimeException{
    public NotFoundOnDataBaseException(String msg){
        super(msg);
    }
}
