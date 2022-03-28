package com.bnp.lafabrique.ddd.presentation.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDetail> handleIlllegalArgumentException(IllegalArgumentException iae) {
        ErrorDetail errorDetail=new ErrorDetail("Invalid Request argument",iae.getMessage(),4004);
        return new ResponseEntity<ErrorDetail>(errorDetail,null, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDetail> handleNullPointerException(NullPointerException iae) {
        ErrorDetail errorDetail=new ErrorDetail("argument can't be empty",iae.getMessage(),4005);
        return new ResponseEntity<ErrorDetail>(errorDetail,null, HttpStatus.BAD_REQUEST);

    }
}
