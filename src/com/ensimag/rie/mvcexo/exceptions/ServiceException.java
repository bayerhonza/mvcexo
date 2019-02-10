package com.ensimag.rie.mvcexo.exceptions;

/**
 * Custom exception for services.
 */
public class ServiceException extends Exception {
    public ServiceException(Exception ex) {
        super(ex);
    }

    public ServiceException() {super();}
}
