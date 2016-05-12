package com.github.hirethem.action.profile;

import com.github.hirethem.action.interceptor.AuthorizeAs;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.CurrentUserService;
import com.github.hirethem.model.service.LoginService;
import com.github.hirethem.model.service.UserServiceWithAuthorization;
import com.github.hirethem.model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

import static com.github.hirethem.constants.ActionMessages.EMPTY_FIELD;

/**
 * Created by egorshulga on 05-May-16.
 */
@AuthorizeAs
public class EditProfileAction extends ActionSupport {

    protected String name;
    protected String surname;
    protected String about;
    protected String contactInfo;
    protected byte[] avatar;
    private String oldPassword;
    private String newPassword;

    private UserServiceWithAuthorization userService = new UserServiceWithAuthorization();

    public String input() throws ServiceException {
        User user = new CurrentUserService().getCurrentUserEntity();
        name = user.getName();
        surname = user.getSurname();
        about = user.getAbout();
        contactInfo = user.getContactInfo();
        avatar = user.getAvatar();
        return INPUT;
    }

    public String execute() {
        try {
            User user = new CurrentUserService().getCurrentUserEntity();
            userService.changeUserInfo(user.getEmail(), user.getUserType(), name, surname, about, contactInfo, avatar);
        } catch (ServiceException ignored) {
        }
        return SUCCESS;
    }

    public void validate() {
        try {
            User user = new CurrentUserService().getCurrentUserEntity();
            new LoginService().tryAuthenticateUser(user.getEmail(), oldPassword, user.getUserType());
        } catch (ServiceException e) {
            addActionError(e.getMessage());
        }
    }

    @RequiredStringValidator(message = EMPTY_FIELD)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @RequiredStringValidator(message = EMPTY_FIELD)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
