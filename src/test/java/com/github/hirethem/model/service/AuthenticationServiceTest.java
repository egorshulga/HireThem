package com.github.hirethem.model.service;

import com.github.hirethem.model.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by egorshulga on 01-May-16.
 */
public class AuthenticationServiceTest {
    private AuthenticationService authenticationService;
    private UserService userService;

    private String email = "mr@ololo.com";
    private String password = "ololo";
    private String name = "Mr";
    private String surname = "Ololo";
    private User.UserType userType = User.UserType.EMPLOYEE;


    @Before
    public void setUp() throws Exception {
        authenticationService = new AuthenticationService();
        userService = new UserService();
        userService.createNewUser(email, userType, name, surname, password);
    }

    @After
    public void tearDown() throws Exception {
        userService.deleteUser(email, userType);
    }

    @Test
    public void verifyUser() throws Exception {
        int userId = userService.getUserId(email, userType);
        authenticationService.verifyUser(userId, email, userType);
    }

    @Test
    public void isThereUserWithSuchCredentials() throws Exception {
        int userId = userService.getUserId(email, userType);
        assertTrue(authenticationService.isThereUserWithSuchCredentials(userId, email, userType));
    }

    @Test
    public void isUserAdmin() throws Exception {
        userService.promoteUser(email, userType);
        assertTrue(authenticationService.isUserAdmin(email, userType));
    }

}