package com.github.hirethem.model.service;

import com.github.hirethem.model.dao.UserDao;
import com.github.hirethem.model.dao.exception.DaoException;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.exception.ServiceException;
import com.github.hirethem.model.util.PasswordEncryptionService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by egors.
 */
public class UserService {
    private UserDao userDao = new UserDao();

    private static List<User.UserType> userTypes = new ArrayList<>();

    static {
        userTypes.add(User.UserType.employee);
        userTypes.add(User.UserType.employer);
    }

    public static List<User.UserType> getUserTypes() {
        return userTypes;
    }

    public boolean isSuchUserRegistered(String email, User.UserType userType) {
        try {
            User user = userDao.getUser(email, userType);
            return user != null;
        } catch (DaoException e) {
            return false;
        }
    }

    public User getUser(int id) throws DaoException {
        return userDao.getUser(id);
    }

    public User getUser(String email, User.UserType userType) throws DaoException {
        return userDao.getUser(email, userType);
    }

    public int getUserId(String email, User.UserType userType) throws DaoException {
        User user = getUser(email, userType);
        return user.getId();
    }

    public void createNewUser(String email, String password, String name,
                              String surname, User.UserType userType) throws ServiceException {
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


    public void deleteUser(String email, User.UserType userType) {
        userDao.deleteUser(email, userType);
    }
}
