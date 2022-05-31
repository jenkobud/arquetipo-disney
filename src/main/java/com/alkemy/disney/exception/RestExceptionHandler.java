package com.alkemy.disney.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

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
        ErrorResponse res = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, /*ex.getMessage()*/"jaja mira mi error");
        return buildResponseEntity(res);
    }
//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<Object> handleNoSuchElementException(HttpServletRequest req, NoSuchElementException ex){
//        ErrorResponse res = new ErrorResponse();
//        res.setMessage("The row for address is not existent: " + req.getRequestURI());
//        return buildResponseEntity(res);
//    }
//
//    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
//    public ResponseEntity<Object> handleNoSuchElementException(HttpServletRequest req, SQLIntegrityConstraintViolationException ex){
//        String err = "Unable to submit post: " + ex.getMessage();
//        return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, err));
//    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse){
        return new ResponseEntity<Object>(errorResponse, errorResponse.getStatus());
    }
}
