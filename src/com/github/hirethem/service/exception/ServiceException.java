package com.github.hirethem.service.exception;


import com.github.hirethem.exception.ProjectException;

public class ServiceException extends ProjectException {
    private static final long serialVersionUID = 1;

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String message, Exception e){
        super(message, e);
    }
}
