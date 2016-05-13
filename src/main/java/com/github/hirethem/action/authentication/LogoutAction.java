package com.github.hirethem.action.authentication;

import com.github.hirethem.action.interceptor.AuthorizeAs;
import com.github.hirethem.model.service.LogoutService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by egors.
 */
public class LogoutAction extends ActionSupport {

    private LogoutService logoutService = new LogoutService();

    public String execute() {
        logoutService.logoutUser();
        return SUCCESS;
    }

}
