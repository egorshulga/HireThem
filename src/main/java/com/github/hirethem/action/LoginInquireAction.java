package com.github.hirethem.action;

import com.github.hirethem.model.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by egors.
 */

public class LoginInquireAction extends ActionSupport {


    public String execute() {
        if (new LoginService().isUserAuthenticated()) {
            return SUCCESS;
        } else {
            return LOGIN;
        }
    }

}
