package com.github.hirethem.model.service;

import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.exception.ServiceException;

/**
 * Created by egorshulga on 01-May-16.
 */
public class UserServiceWithAuthorization extends UserService {

    private AuthenticationService authenticationService = new AuthenticationService();

    public void changeUserInfoWithSecurityCheck(String email, User.UserType userType, String name, String surname, String about,
                                                String contactInfo, byte[] avatar) throws ServiceException {
        if (authenticationService.isCurrentUserAdmin() || authenticationService.isUserCurrent(email, userType)) {
            changeUserInfo(email, userType, name, surname, about, contactInfo, avatar);
        }
    }

    public void promoteUserWithSecurityCheck(String email, User.UserType userType) throws ServiceException {
        authenticationService.isCurrentUserAdmin();
        promoteUser(email, userType);
    }

    public void demoteUserWithSecurityCheck(String email, User.UserType userType) throws ServiceException {
        authenticationService.isCurrentUserAdmin();
        demoteUser(email, userType);
    }

    public void deleteUserWithSecurityCheck(String email, User.UserType userType) throws ServiceException {
        if (authenticationService.isCurrentUserAdmin() || authenticationService.isUserCurrent(email, userType)) {
            deleteUser(getUserId(email, userType));
        }
    }


}
