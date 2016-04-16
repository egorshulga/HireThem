package com.github.hirethem.action;

import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.LoginService;
import com.github.hirethem.model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by egors.
 */

public class LoginInquireAction extends ActionSupport {

    private User user;

    public String execute() {
        try {
            user = new LoginService().getAuthenticatedUser();
        } catch (ServiceException e) {
            return LOGIN;
        }
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
