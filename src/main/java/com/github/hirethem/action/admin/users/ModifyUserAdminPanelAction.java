package com.github.hirethem.action.admin.users;

import com.github.hirethem.action.profile.EditProfileAction;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.SessionService;
import com.github.hirethem.model.service.UserService;
import com.github.hirethem.model.service.exception.ServiceException;

/**
 * Created by egorshulga on 12-May-16.
 */
public class ModifyUserAdminPanelAction extends EditProfileAction {

    private int userId;

    public String execute() {
        try {
            User user = new UserService().getUser((Integer) new SessionService().getValue("userId"));
            new UserService().changeUserInfo(user.getEmail(), user.getUserType(), name, surname, about, contactInfo, avatar);
        } catch (ServiceException ignored) { }
        return SUCCESS;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
