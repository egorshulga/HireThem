package com.github.hirethem.model.service;

import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by egorshulga on 01-May-16.
 */
public class CurrentUserService {

    private UserService userService = new UserService();
    private CookieService cookieService = new CookieService();
    private SessionService sessionService = new SessionService();

    public User getCurrentUserEntity() throws ServiceException {
        int userId = cookieService.getCurrentUserId();
        String userToken = sessionService.getUserToken(userId);
        if (!StringUtils.equals(cookieService.getUserToken(), userToken)){
            throw new ServiceException("Wrong token");
        }
        return userService.getUser(userId);
    }

    public int getCurrentUserId() throws ServiceException {
        return getCurrentUserEntity().getId();
    }

}
