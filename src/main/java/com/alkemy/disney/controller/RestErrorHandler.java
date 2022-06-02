package com.alkemy.disney.controller;

import com.alkemy.disney.exception.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler( value = {Throwable.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND )
    public ResponseEntity<Object> handleThrowable(Throwable ex, WebRequest req){
        //handleException
        ErrorResponse res = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
        return buildResponseEntity(res);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest req){
        StringBuilder errorMsg = new StringBuilder("");
        for (FieldError er : ex.getFieldErrors()){
            errorMsg.append(String.format(" '%s' on field '%s' -> %s. | ", er.getObjectName(), er.getField(), er.getDefaultMessage()));
        }
        for (ObjectError er : ex.getGlobalErrors()){
            errorMsg.append(String.format(" '%s' -> %s. | ", er.getObjectName(), er.getDefaultMessage()));
        }
        ErrorResponse er = new ErrorResponse(status, errorMsg.toString());
        return buildResponseEntity(er);
    }
    /* Handles 404 errors*/
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        return buildResponseEntity(new ErrorResponse(status, ex.getMessage()));
    }



    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse){
        return new ResponseEntity<Object>(errorResponse, errorResponse.getStatus());
    }
}
