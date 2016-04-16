package com.github.hirethem.action;

import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.SignInService;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by egors.
 */
public class SignInInquireAction extends ActionSupport {

    public String execute() {
        return SUCCESS;
    }

    public List<User.UserType> getUserTypes() {
        return SignInService.getUserTypes();
    }

    public User.UserType getDefaultUserType() {
        return User.UserType.employee;
    }
}
