package com.github.hirethem.action.admin.users;

import com.github.hirethem.action.interceptor.AuthorizeAs;
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
@AuthorizeAs(admin = true)
public class ModifyUserAdminPanelAction extends EditProfileAction {

    private int userId;
    private User.UserType userType;
    private boolean isAdmin;

    public String input() throws ServiceException {
        User user = new UserService().getUser(userId);
        new SessionService().put("userId", userId);
        name = user.getName();
        surname = user.getSurname();
        about = user.getAbout();
        contactInfo = user.getContactInfo();
        avatar = user.getAvatar();
        userId = user.getId();
        isAdmin = user.getIsAdmin();
        userType = user.getUserType();
        return INPUT;
    }

    public String execute() {
        try {
            UserService userService = new UserService();
            User user = userService.getUser((Integer) new SessionService().getValue("userId"));
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

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }

    public User.UserType getUserType() {
        return userType;
    }

    public void setUserType(User.UserType userType) {
        this.userType = userType;
    }

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }

    public User.UserType[] getUserTypes() {
        return User.UserType.values();
    }


}
