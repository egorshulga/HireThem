package com.github.hirethem.model.service;

import com.github.hirethem.model.dao.UserDao;
import com.github.hirethem.model.dao.exception.DaoException;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.exception.ServiceException;

import static com.github.hirethem.Const.TOKEN_COOKIE;

/**
 * Created by egors.
 */
public class LoginService {

    private CookieService cookieService = new CookieService();
    private SessionService sessionService = new SessionService();

    public void tryAuthenticateUser(String email, String password, User.UserType userType) throws ServiceException {
        UserDao userDao = new UserDao();

        byte[] salt;
        try {
            salt = userDao.getSalt(email, userType);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        byte[] encryptedInputPassword;
        try {
            encryptedInputPassword = userDao.getEncryptedPassword(email, userType);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        new PasswordEncryptionService().tryAuthenticateUser(password, encryptedInputPassword, salt);
    }

    public User getAuthenticatedUser() throws ServiceException {
        String token = cookieService.get(TOKEN_COOKIE);
        int userId = sessionService.getAuthorizedUserIdByToken(token);
        try {
            return new UserDao().getUser(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean isUserAuthenticated() {
        String token = null;
        try {
            token = cookieService.get(TOKEN_COOKIE);
            int userId = sessionService.getAuthorizedUserIdByToken(token);
            return true;
        } catch (ServiceException e) {
            return false;
        }
    }

    public void saveUserAuthentication(int userId) {
        String token = sessionService.saveUserAuthorization(userId);
        cookieService.add(TOKEN_COOKIE, token);
    }


    public void saveUserAuthentication(String email, User.UserType userType) {
        int userId = 0;
        try {
            userId = new UserService().getUserId(email, userType);
        } catch (DaoException ignored) {
            // this check is redundant
        }
        saveUserAuthentication(userId);
    }
}
