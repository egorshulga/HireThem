package com.github.hirethem.action.authentication;

import com.github.hirethem.model.service.LogoutService;

/**
 * Created by egors.
 */
public class LogoutAction extends AuthorizationRequired {

    private LogoutService logoutService = new LogoutService();

    public String execute() {
        logoutService.logoutUser();
        return SUCCESS;
    }

}
