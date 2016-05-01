package com.github.hirethem.model.service;

import com.github.hirethem.model.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by egorshulga on 01-May-16.
 */
public class UserCreationTest {
    private UserService userService;

    private String email = "mr@ololo.com";
    private String password = "ololo";
    private String name = "Mr";
    private String surname = "Ololo";
    private User.UserType userType = User.UserType.EMPLOYEE;

    @Before
    public void setUp() throws Exception {
        userService = new UserService();
    }

    @After
    public void tearDown() throws Exception {
        userService.deleteUser(userService.getUserId(email, userType));
    }


    @Test
    public void createUser() throws Exception {
        userService.createNewUser(email, userType, name, surname, password);
        assertNotNull(userService.getUser(email, userType));
    }


}
