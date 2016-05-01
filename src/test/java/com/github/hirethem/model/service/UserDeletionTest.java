package com.github.hirethem.model.service;

import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.exception.ServiceException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;


/**
 * Created by egorshulga on 01-May-16.
 */
public class UserDeletionTest {

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

    @Test(expected = ServiceException.class)
    public void deleteNotPresentUser() throws Exception {
        userService.deleteUser(userService.getUserId(email, userType));
    }

    @Test(expected = ServiceException.class)
    public void deletePresentUserById() throws Exception {
        userService.createNewUser(email, userType, name, surname, password);

        userService.deleteUser(userService.getUserId(email, userType));

        User user = userService.getUser(email, userType);
        assertNull(user);
    }

    @Test(expected = ServiceException.class)
    public void deletePresentUserByEmail() throws Exception {
        userService.createNewUser(email, userType, name, surname, password);

        userService.deleteUser(email, userType);

        User user = userService.getUser(email, userType);
        assertNull(user);
    }

}
