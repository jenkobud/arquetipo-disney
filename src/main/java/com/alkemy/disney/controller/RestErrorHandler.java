package com.alkemy.disney.controller;


import com.alkemy.disney.exception.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Set;


@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler( Throwable.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR )
    public ResponseEntity<Object> handleThrowable(Throwable ex, HttpHeaders headers, HttpStatus status, WebRequest req){
        ErrorResponse res = new ErrorResponse(status, String.format("%s", ex.getMessage()));
        return buildResponseEntity(res);
    }

    /* INTERNAL_SERVER_ERROR - 500*/
    @Override
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR )
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(new ErrorResponse(status, ex.getLocalizedMessage()));
    }
    /* Handles 404 errors*/
    @Override
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        return buildResponseEntity(new ErrorResponse(status, ex.getLocalizedMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        pageNotFoundLogger.warn(ex.getMessage());
        Set<HttpMethod> supportedMethods = ex.getSupportedHttpMethods();
        if (!CollectionUtils.isEmpty(supportedMethods)) {
            headers.setAllow(supportedMethods);
        }
        ErrorResponse er = new ErrorResponse(status, ex.getLocalizedMessage());
        return buildResponseEntity(er);
    }
    /* Handle @Valid Annotations */
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



    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse){
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }
}
