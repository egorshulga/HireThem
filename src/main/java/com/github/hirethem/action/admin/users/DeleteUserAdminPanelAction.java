package com.github.hirethem.action.admin.users;

import com.github.hirethem.action.interceptor.AuthorizeAs;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.CurrentUserService;
import com.github.hirethem.model.service.SessionService;
import com.github.hirethem.model.service.UserService;
import com.github.hirethem.model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by egorshulga on 12-May-16.
 */
@AuthorizeAs(admin = true)
public class DeleteUserAdminPanelAction extends ActionSupport {

    private int userId;

    public String execute() {
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

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }


}
