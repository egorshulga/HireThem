package com.github.hirethem.action.admin.users;

import com.github.hirethem.model.service.SessionService;
import com.github.hirethem.model.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by egorshulga on 12-May-16.
 */
public class DeleteUserAdminPanelAction extends ActionSupport {

    private int userId;

    public String execute() {
        userId = (int) new SessionService().getValue("userId");
        new UserService().deleteUser(userId);
        new SessionService().removeUser(userId);
        return SUCCESS;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
