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
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    /* 404 ERROR HANDLING */
//    @ExceptionHandler(NoHandlerFoundException.class)
//    public ResponseEntity<Object> handleNoHandlerFoundException(HttpServletRequest req, NoHandlerFoundException ex){
//        ErrorResponse res = new ErrorResponse(HttpStatus.NOT_FOUND);
//        res.setMessage("The path is not existent: " + req.getRequestURI());
//        return buildResponseEntity(res);
//    }

    // @Overdrive-> handleMethodArgumentNotValid() terminar
    @ExceptionHandler( value = {Throwable.class})
    public ResponseEntity<Object> handleThrowable(Throwable ex, WebRequest req){
        //handleException
        ErrorResponse res = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return buildResponseEntity(res);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest req){
        String errorMsg = "";
        //Not entering in fors... BORRAR
        for (FieldError er : ex.getBindingResult().getFieldErrors()){
            errorMsg.concat(er.getObjectName() + " -> " + er.getDefaultMessage());
        }
        for (ObjectError er : ex.getBindingResult().getGlobalErrors()){
            errorMsg.concat(er.getObjectName() + " -> " + er.getDefaultMessage());
        }
        ErrorResponse er = new ErrorResponse(status, errorMsg);
        return buildResponseEntity(er);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse){
        return new ResponseEntity<Object>(errorResponse, errorResponse.getStatus());
    }
}
