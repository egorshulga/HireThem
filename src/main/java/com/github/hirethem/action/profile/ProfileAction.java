package com.github.hirethem.action.profile;

import com.github.hirethem.action.interceptor.AuthorizeAs;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.CurrentUserService;
import com.github.hirethem.model.service.UserService;
import com.github.hirethem.model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by egorshulga.
 */
@AuthorizeAs()
public class ProfileAction extends ActionSupport {

    private User user;
    private String mailToLink;

    public String execute() throws ServiceException {
        user = new CurrentUserService().getCurrentUserEntity();
        mailToLink = new UserService().getUserMailtoLink(user.getId());
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMailToLink() {
        return mailToLink;
    }

    public void setMailToLink(String mailToLink) {
        this.mailToLink = mailToLink;
    }
}
