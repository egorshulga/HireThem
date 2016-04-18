package com.github.hirethem.model.service;

import com.github.hirethem.Const;
import com.github.hirethem.model.dao.SessionDao;
import com.github.hirethem.model.service.exception.ServiceException;

import java.util.UUID;

import static com.github.hirethem.model.service.exception.ServiceErrorMessage.COOKIE_NOT_FOUND;

/**
 * Created by egors.
 */
public class SessionService {

    private SessionDao sessionDao = new SessionDao();

    private String generateSessionToken() {
        return UUID.randomUUID().toString();
    }

    public String saveUserAuthorization(int id) {
        String token = generateSessionToken();
        sessionDao.put(token, id);     // token => user id
        return token;
    }

//    public String getUserToken(int id) {
//        return (String) new SessionDao().getValue(id);
//    }

    public int getAuthorizedUserIdByToken(String token) throws ServiceException {
        try {
            return (int) sessionDao.getValue(token);
        } catch (Exception e) {
            throw new ServiceException(COOKIE_NOT_FOUND);
        }
    }

    public void logoutUser() {
        sessionDao.remove(Const.TOKEN_COOKIE);
    }

}

