package com.ensimag.rie.mvcexo.exceptions;

public class ServiceException extends Exception {
    public ServiceException(Exception ex) {
        super(ex);
    }
}
