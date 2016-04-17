package com.github.hirethem.model.service;

import static com.github.hirethem.Const.TOKEN_COOKIE;

/**
 * Created by egors.
 */
public class LogoutService {

    CookieService cookieService = new CookieService();
    SessionService sessionService = new SessionService();

    public void logoutUser() {
        cookieService.remove(TOKEN_COOKIE);
        sessionService.logoutUser();
    }

}
