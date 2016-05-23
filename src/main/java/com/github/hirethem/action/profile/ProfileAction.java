package com.github.hirethem.action.profile;

import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.CurrentUserService;
import com.github.hirethem.model.service.UserService;
import com.github.hirethem.model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by egorshulga on 22-May-16.
 */
public class ProfileAction extends ActionSupport {

    protected int id;
    protected String email;
    protected User.UserType userType;
    protected String name;
    protected String surname;
    protected String about;
    protected String contactInfo;
    protected byte[] avatar;

    public String input() throws ServiceException {
        User user = new UserService().getUser(id);
        name = user.getName();
        surname = user.getSurname();
        about = user.getAbout();
        contactInfo = user.getContactInfo();
        avatar = user.getAvatar();
        email = user.getEmail();
        userType = user.getUserType();
        return INPUT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getMailtoLink() throws ServiceException {
        UserService userService = new UserService();
        User user = new CurrentUserService().getCurrentUserEntity();
        return userService.getUserMailtoLink(userService.getUserId(user.getEmail(), user.getUserType()));
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User.UserType getUserType() {
        return userType;
    }

    public void setUserType(User.UserType userType) {
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }

}
