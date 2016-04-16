package com.github.hirethem.model.service;

import com.github.hirethem.model.Const;
import com.github.hirethem.model.dao.SessionDao;

import java.util.UUID;

/**
 * Created by egors.
 */
public class SessionService {

    private SessionDao sessionDao = new SessionDao();

    private String generateSessionToken() {
        return UUID.randomUUID().toString();
    }

    public String saveUserAuthorization(String email) {
        String token = generateSessionToken();
        sessionDao.put(token, email);     // token => user email
        return token;
    }

    public String getUserToken(String email) {
        return (String) new SessionDao().getValue(email);
    }

    public String getAuthenticatedUserEmailByToken(String token) {
        return (String) sessionDao.getValue(token);
    }

    public void logoutUser() {
        sessionDao.remove(Const.TOKEN_COOKIE);
    }

}

