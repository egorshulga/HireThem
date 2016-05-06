package com.github.hirethem.action.interceptor;

import com.github.hirethem.model.entity.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by egorshulga.
 */
// The class is a marker for the actions that do require authorization
public abstract class AuthorizationRequired extends ActionSupport {

    protected User.UserType userType;
    protected String email;
    protected boolean isAdmin;

    public User.UserType getUserType() {
        return userType;
    }

    public void setUserType(User.UserType userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
