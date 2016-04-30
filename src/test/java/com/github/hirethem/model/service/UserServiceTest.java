package com.github.hirethem.model.service;

import com.github.hirethem.model.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by egorshulga on 29-Apr-16.
 */
public class UserServiceTest {
    private UserService userService;

    private String email = "mr@ololo.com";
    private String password = "ololo";
    private String name = "Mr";
    private String surname = "Ololo";
    private User.UserType userType = User.UserType.employee;

    @Before
    public void setUp() throws Exception {
        userService = new UserService();

        userService.createNewUser(email, password, name, surname, userType);
    }

    @After
    public void tearDown() throws Exception {
        userService.deleteUserWithoutRightsCheck(userService.getUserId(email, userType));
    }

    @Test
    public void isSuchUserRegistered() throws Exception {
        assertTrue(userService.isSuchUserRegistered(email, userType));
    }

    @Test
    public void checkCreatedUser() throws Exception {
        User user = userService.getUser(email, userType);
        assertEquals(email, user.getEmail());
        assertEquals(name, user.getName());
        assertEquals(surname, user.getSurname());
        assertEquals(userType, user.getUserType());
    }

    @Test
    public void getUser() throws Exception {
        User user = userService.getUser(email, userType);
        assertNotNull(user);
    }

}
