package com.github.hirethem.model.service;

import com.github.hirethem.model.dao.CookieDao;
import com.github.hirethem.model.service.exception.ServiceException;

/**
 * Created by egorshulga on 23-Apr-16.
 */
public class CookieService {

    private CookieDao cookieDao = new CookieDao();

    static private final String userIdCookieName = "user-id";
    static private final String userTokenCookieName = "user-token";

    public void addUserIdCookie(int userId) {
        cookieDao.add(userIdCookieName, String.valueOf(userId));
    }

    public void addUserTokenCookie(String token) {
        cookieDao.add(userTokenCookieName, token);
    }

    public void deleteAllCookies() {
        cookieDao.remove(userIdCookieName);
        cookieDao.remove(userTokenCookieName);
    }

    public int getUserId() throws ServiceException {
        try {
            return Integer.parseInt(cookieDao.get(userIdCookieName));
        } catch (NumberFormatException e) {
            throw new ServiceException(e);
        }
    }

    public String getUserToken() throws ServiceException {
        return cookieDao.get(userTokenCookieName);
    }

}
