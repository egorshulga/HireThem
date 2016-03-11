package com.github.hirethem.dao.connectionpool.exception;


import com.github.hirethem.exception.ProjectException;

public class ConnectionPoolException extends ProjectException {
    private static final long serialVersionUID = 1;

    public ConnectionPoolException(String message){
        super(message);
    }

    public ConnectionPoolException(String message, Exception e){
        super(message, e);
    }
}
