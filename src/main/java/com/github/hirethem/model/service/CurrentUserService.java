package com.github.hirethem.model.service;

import com.github.hirethem.model.dao.UserDao;
import com.github.hirethem.model.dao.exception.DaoException;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.exception.ServiceException;

/**
 * Created by egorshulga on 01-May-16.
 */
public class CurrentUserService {

    private UserDao userDao = new UserDao();

    public User getCurrentUserEntity() throws ServiceException {
        int userId = new CookieService().getCurrentUserId();
        try {
            return userDao.getUser(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public int getCurrentUserId() throws ServiceException {
        return getCurrentUserEntity().getId();
    }

    public void changeCurrentUserInfo(String name, String surname, String about,
                                      String contactInfo, byte[] avatar) throws ServiceException {
        int userId = new CookieService().getCurrentUserId();
        userDao.updateUser(userId, name, surname, about, contactInfo, avatar);
    }



}
