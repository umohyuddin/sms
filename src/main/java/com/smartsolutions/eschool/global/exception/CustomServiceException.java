package com.smartsolutions.eschool.global.exception;

import org.springframework.dao.DataAccessException;

public class CustomServiceException extends RuntimeException {
    public CustomServiceException(String s, Exception dae) {
        super(s, dae);
    }
    public CustomServiceException(String s){
        super(s);
    }

}
