package com.github.hirethem.model.dao.exception;

import com.github.hirethem.exception.ProjectException;

/**
 * Created by egors.
 */
public class DaoException extends ProjectException {
    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Exception maskedException) {
        super(message, maskedException);
    }
}
