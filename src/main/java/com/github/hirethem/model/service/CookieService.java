package com.github.hirethem.model.service;

import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;

/**
 * Created by egors.
 */
public class CookieService {

    public String get(String key) {
        for(Cookie cookie : ServletActionContext.getRequest().getCookies()) {
            if (cookie.getName().equals(key)) {
                return cookie.getValue();
            }
        }
        return "";
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
