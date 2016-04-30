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

//    private CookieService cookieService = new CookieService();
//    private SessionService sessionService = new SessionService();

    private static List<User.UserType> userTypes = new ArrayList<>();

    static {
        userTypes.add(User.UserType.EMPLOYEE);
        userTypes.add(User.UserType.EMPLOYER);
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

    public User getUser(int id) throws ServiceException {
        try {
            return userDao.getUser(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public User getUser(String email, User.UserType userType) throws ServiceException {
        try {
            return userDao.getUser(email, userType);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public int getUserId(String email, User.UserType userType) throws ServiceException {
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

    public User getCurrentUserEntity() throws ServiceException {
        int userId = new CookieService().getCurrentUserId();
        try {
            return userDao.getUser(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void changeCurrentUserInfo(String name, String surname, String about,
                               String contactInfo, byte[] avatar) throws ServiceException {
        int userId = new CookieService().getCurrentUserId();
        userDao.updateUser(userId, name, surname, about, contactInfo, avatar);
    }

    public void verifyIsCurrentUserAdmin() throws ServiceException {
        if (!getCurrentUserEntity().isAdmin()) {
            throw new ServiceException("Current user is not authorized to perform the task");
        }
    }

    public void verifyCurrentUserToken() throws ServiceException {
        CookieService cookieService = new CookieService();
        SessionService sessionService = new SessionService();
        String userToken = cookieService.getUserToken();
        int userId = cookieService.getCurrentUserId();
        if (!userToken.equals(sessionService.getUserToken(userId))) {
            throw new ServiceException("User has provided wrong token");
        }
    }

    public void promoteUser(String email, User.UserType userType) throws ServiceException {
        verifyIsCurrentUserAdmin();
        userDao.promoteUserAsAdmin(getUserId(email, userType));
    }

    public void demoteUser(String email, User.UserType userType) throws ServiceException {
        verifyIsCurrentUserAdmin();
        userDao.demoteUser(getUserId(email, userType));
    }

    public void deleteUser(String email, User.UserType userType) throws ServiceException {
        verifyIsCurrentUserAdmin();
        int userToDeleteId = getUserId(email, userType);
        if (userToDeleteId != new CookieService().getCurrentUserId()) {
            throw new ServiceException("User has no rights to perform the task");
        }
        userDao.deleteUser(email, userType);
    }

    // implemented for test purposes
    public void deleteUserWithoutRightsCheck(int userId) {
        userDao.deleteUser(userId);
    }

}
