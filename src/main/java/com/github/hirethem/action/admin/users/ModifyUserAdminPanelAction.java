package com.github.hirethem.action.admin.users;

import com.github.hirethem.action.profile.EditProfileAction;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.CurrentUserService;
import com.github.hirethem.model.service.SessionService;
import com.github.hirethem.model.service.UserService;
import com.github.hirethem.model.service.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by egorshulga on 12-May-16.
 */
public class ModifyUserAdminPanelAction extends EditProfileAction {

    private int userId;
    private boolean isAdmin;

    public String input() throws ServiceException {
        User user = new CurrentUserService().getCurrentUserEntity();
        name = user.getName();
        surname = user.getSurname();
        about = user.getAbout();
        contactInfo = user.getContactInfo();
        avatar = user.getAvatar();
        userId = user.getId();
        isAdmin = user.isAdmin();
        return INPUT;
    }

    public String execute() {
        try {
            User user = new UserService().getUser((Integer) new SessionService().getValue("userId"));
            UserService userService = new UserService();
            userService.changeUserInfo(user.getEmail(), user.getUserType(), name, surname, about, contactInfo, avatar);
            if (isAdmin) {
                userService.promoteUser(user.getEmail(), user.getUserType());
            } else {
                userService.demoteUser(user.getEmail(), user.getUserType());
            }
            if (StringUtils.isNotBlank(getNewPassword())) {
                userService.changeUserPassword(user.getId(), getNewPassword());
            }
        } catch (ServiceException ignored) {
        }
        return SUCCESS;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
