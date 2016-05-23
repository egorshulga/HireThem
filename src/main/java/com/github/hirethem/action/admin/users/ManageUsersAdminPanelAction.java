package com.github.hirethem.action.admin.users;

import com.github.hirethem.action.interceptor.AuthorizeAs;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.CurrentUserService;
import com.github.hirethem.model.service.SessionService;
import com.github.hirethem.model.service.UserService;
import com.github.hirethem.model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by egorshulga on 12-May-16.
 */
@AuthorizeAs(admin = true)
public class ManageUsersAdminPanelAction extends ActionSupport {

    private List<User> users;
    private int userId;

    public String input() {
        users = new UserService().getAllUsers();
        return INPUT;
    }

    public String execute() {
        new SessionService().put("userId", userId);
        return SUCCESS;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
