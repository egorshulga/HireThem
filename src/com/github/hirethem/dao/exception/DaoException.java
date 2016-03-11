package com.github.hirethem.dao.exception;


import com.github.hirethem.exception.ProjectException;

public class DaoException extends ProjectException {
    private static final long serialVersionUID = 1;

    public DaoException(String message){
        super(message);
    }

    public DaoException(String message, Exception e){
        super(message, e);
    }
}
