package com.github.hirethem.model.service;

import com.github.hirethem.model.dao.UserDao;
import com.github.hirethem.model.dao.exception.DaoException;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

import static com.github.hirethem.model.service.exception.ServiceErrorMessage.EMAIL_IS_REGISTERED;

/**
 * Created by egors.
 */
public class SignInService {
    private static List<User.UserType> userTypes = new ArrayList<>();

    static {
        userTypes.add(User.UserType.employee);
        userTypes.add(User.UserType.employer);
    }

    public static List<User.UserType> getUserTypes() {
        return userTypes;
    }

    public void checkIsThisEmailRegistered(String email) throws ServiceException {
        UserDao userDao = new UserDao();
        try {
            if (userDao.getUser(email) != null) {
                throw new ServiceException(EMAIL_IS_REGISTERED);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void createNewUser(String email, String password, String name,
                              String surname, User.UserType userType) throws ServiceException {
        UserDao userDao = new UserDao();
        PasswordEncryptionService passwordEncryptionService = new PasswordEncryptionService();
        byte[] salt;
        salt = passwordEncryptionService.generateSalt();

        byte[] encryptedPassword;
        try {
            encryptedPassword = passwordEncryptionService.getEncryptedPassword(password, salt);
        } catch (Exception e) {
            throw new ServiceException(e);
        }

        userDao.createNewUser(email, encryptedPassword, salt, name, surname, userType);

    }
}
