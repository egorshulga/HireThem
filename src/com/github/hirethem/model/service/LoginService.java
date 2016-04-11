package com.github.hirethem.model.service;

import com.github.hirethem.model.dao.LoginDao;
import com.github.hirethem.model.dao.exception.DaoException;
import com.github.hirethem.model.service.exception.ServiceException;

import java.util.Arrays;

/**
 * Created by egors.
 */
public class LoginService {

    private LoginDao loginDao = new LoginDao();

    public void authenticateUser(String email, String password) throws ServiceException {
        LoginDao loginDao = new LoginDao();

        byte[] salt;
        try {
            salt = loginDao.getSalt(email);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        PasswordEncryptionService passwordEncryptionService = new PasswordEncryptionService();
        byte[] encryptedInputPassword;
        try {
            encryptedInputPassword = passwordEncryptionService.getEncryptedPassword(password, salt);
        } catch (Exception e) {
            throw new ServiceException("Unable to perform password encryption", e);
        }

        byte[] encryptedRealPassword;
        try {
            encryptedRealPassword = loginDao.getEncryptedPassword(email);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        if (!Arrays.equals(encryptedInputPassword, encryptedRealPassword)) {
            throw new ServiceException("Wrong email or password");
        }
    }

}
