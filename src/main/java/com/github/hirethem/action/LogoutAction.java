package com.github.hirethem.action;

import com.github.hirethem.action.interceptor.AuthorizationRequired;
import com.github.hirethem.model.service.LogoutService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by egors.
 */
public class LogoutAction extends ActionSupport implements AuthorizationRequired {

    private LogoutService logoutService = new LogoutService();

    public String execute() {
        logoutService.logoutUser();
        return SUCCESS;
    }

}
