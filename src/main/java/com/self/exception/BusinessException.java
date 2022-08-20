package com.self.exception;

public class BusinessException extends RuntimeException{

    private static final long serialVersionId =1348771109171435607L;
    public BusinessException(String message){
        super(message);
    }
}
