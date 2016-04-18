package com.github.hirethem.model.service;

import com.github.hirethem.model.service.exception.ServiceException;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;

/**
 * Created by egors.
 */
public class CookieService {

    public String get(String key) throws ServiceException {
        for(Cookie cookie : ServletActionContext.getRequest().getCookies()) {
            if (cookie.getName().equals(key)) {
                return cookie.getValue();
            }
        }
        throw new ServiceException("Cookie not found");
    }

    public void add(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        ServletActionContext.getResponse().addCookie(cookie);
    }

    public void remove(String key) {
        Cookie cookie = new Cookie(key, "");
        cookie.setMaxAge(0);
        ServletActionContext.getResponse().addCookie(cookie);
    }
}
