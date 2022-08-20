package com.self.exception;

import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

// This class is to handle the exceptions which are very common in applicaitions
// in this class i am adding one method to handle the exception which we are thowing in an applicaiton i.e, which is not very
// common exception as said above
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest webRequest){

        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage()); // this is required to show specific exception instead of whole stack trace on postman screen
        return  new ResponseEntity<>(ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest webRequest){

        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage()); // this is required to show specific exception instead of whole stack trace on postman screen
        return  new ResponseEntity<>(ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest webRequest){

        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage()); // this is required to show specific exception instead of whole stack trace on postman screen
        return  new ResponseEntity<>(ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
// Note : we can combine 2nd and 3rd method in 1 and 1st parameter should be Exception type instead of specific exception ofcourse