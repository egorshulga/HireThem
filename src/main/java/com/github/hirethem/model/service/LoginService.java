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

    public void tryAuthenticateUser(String email, String password) throws ServiceException {
        UserDao userDao = new UserDao();

        byte[] salt;
        try {
            salt = userDao.getSalt(email);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        byte[] encryptedInputPassword;
        try {
            encryptedInputPassword = userDao.getEncryptedPassword(email);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        new PasswordEncryptionService().tryAuthenticateUser(password, encryptedInputPassword, salt);
    }

    public User getAuthenticatedUser() throws ServiceException {
        String token = cookieService.get(TOKEN_COOKIE);
        String email = sessionService.getAuthenticatedUserEmailByToken(token);
        try {
            return new UserDao().getUser(email);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean isUserAuthenticated() {
        String token = cookieService.get(TOKEN_COOKIE);
        String email = sessionService.getAuthenticatedUserEmailByToken(token);
        return !email.equals("");
    }

    public void saveUserAuthetication(String email) {
        String token = sessionService.saveUserAuthorization(email);
        cookieService.add(TOKEN_COOKIE, token);
    }


}
