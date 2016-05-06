package com.github.hirethem.action.profile;

import com.github.hirethem.action.interceptor.AuthorizationRequired;
import com.github.hirethem.model.service.UserService;
import com.github.hirethem.model.service.exception.ServiceException;

/**
 * Created by egorshulga.
 */
public class ProfileAction extends AuthorizationRequired {

    private String name;
    private String surname;
    private String about;
    private String contactInfo;
    private byte[] avatar;

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
        return userService.getUserMailtoLink(userService.getUserId(email, userType));
    }

}
