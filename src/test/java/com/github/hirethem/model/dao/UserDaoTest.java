package com.github.hirethem.model.dao;

import com.github.hirethem.model.dao.exception.DaoException;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.UserService;
import com.mysql.jdbc.AssertionFailedException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by egorshulga on 01-May-16.
 */
public class UserDaoTest {


    private UserDao userDao;
    private UserService userService;

    private String email = "mr@ololo.com";
    private byte[] password = new byte[]{15, 22, 14, 42};
    private byte[] salt = new byte[]{78, 22, 10, 42};
    private String name = "Mr";
    private String surname = "Ololo";
    private User.UserType userType = User.UserType.EMPLOYEE;

    private String nothing = "nothing";

    private int userId;

    @Before
    public void setUp() throws Exception {
        userDao = new UserDao();
        userService = new UserService();
        userDao.createNewUser(email, userType, password, salt, surname, name);
        userId = userService.getUserId(email, userType);
    }

    @After
    public void tearDown() throws Exception {
        userDao.deleteUser(email, userType);
    }

    @Test
    public void getSalt() throws Exception {
        assertEquals(userDao.getSalt(email, userType), salt);
    }

    @Test
    public void getEncryptedPassword() throws Exception {
        assertEquals(userDao.getEncryptedPassword(email, userType), password);
    }

    @Test
    public void getUser() throws Exception {
        User user = userDao.getUser(email, userType);
        assertNotNull(user);
    }

    @Test
    public void getUser1() throws Exception {
        assertNotNull(userDao.getUser(userService.getUserId(email, userType)));
    }

    @Test
    public void deleteUser() throws Exception {
        userDao.deleteUser(userService.getUserId(email, userType));
        User user = null;
        try {
            user = userDao.getUser(email, userType);
            throw new AssertionFailedException(new Exception("Retrieved entity after deletion"));
        } catch (DaoException ignored) {
        }
        assertNull(user);
    }

    @Test
    public void deleteUser1() throws Exception {
        userDao.deleteUser(email, userType);
        User user = null;
        try {
            user = userDao.getUser(email, userType);
            throw new AssertionFailedException(new Exception("Retrieved entity after deletion"));
        } catch (DaoException ignored) {
        }
        assertNull(user);
    }

    @Test
    public void updateUser() throws Exception {
        userDao.updateUser(userService.getUserId(email, userType), nothing, nothing, nothing, nothing, null);
    }

    @Test
    public void changeUserPassword() throws Exception {
        userDao.changeUserPassword(userService.getUserId(email, userType), new byte[]{14}, new byte[]{14});
        User user = userDao.getUser(email, userType);
        assertTrue(Arrays.equals(user.getPasswordSalt(), new byte[]{14}));
        assertTrue(Arrays.equals(user.getEncryptedPassword(), new byte[]{14}));
    }

    @Test
    public void promoteUserAsAdmin() throws Exception {
        userDao.promoteUser(userId);
        User user = userDao.getUser(email, userType);
        assertTrue(user.isAdmin());
    }

    @Test
    public void demoteUser() throws Exception {
        userDao.demoteUser(userId);
        User user = userDao.getUser(email, userType);
        assertFalse(user.isAdmin());
    }

    @Test
    public void getUsers() throws Exception {
        List<User> users = userDao.getAllUsers();
        assertTrue(users.size() > 0);
    }

}