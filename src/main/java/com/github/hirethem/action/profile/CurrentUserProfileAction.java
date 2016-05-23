package com.github.hirethem.action.profile;

import com.github.hirethem.action.interceptor.AuthorizeAs;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.CurrentUserService;
import com.github.hirethem.model.service.exception.ServiceException;

/**
 * Created by egorshulga.
 */
@AuthorizeAs
public class CurrentUserProfileAction extends ProfileAction {

    public String input() throws ServiceException {
        User user = new CurrentUserService().getCurrentUserEntity();
        name = user.getName();
        surname = user.getSurname();
        about = user.getAbout();
        contactInfo = user.getContactInfo();
        avatar = user.getAvatar();
        email = user.getEmail();
        userType = user.getUserType();
        return SUCCESS;
    }

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }


}
