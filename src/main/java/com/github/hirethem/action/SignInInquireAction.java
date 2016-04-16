package com.github.hirethem.action;

import com.github.hirethem.model.entity.UserType;
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

    public List<UserType> getUserTypes() {
        return SignInService.getUserTypes();
    }

    public UserType getDefaultUserType() {
        return UserType.employee;
    }
}
