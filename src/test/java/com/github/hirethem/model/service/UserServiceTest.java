package com.github.hirethem.model.service;

import com.github.hirethem.model.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
    private User.UserType userType = User.UserType.EMPLOYEE;

    @Before
    public void setUp() throws Exception {
        userService = new UserService();
        userService.createNewUser(email, userType, name, surname, password);
    }

    @After
    public void tearDown() throws Exception {
        userService.deleteUser(userService.getUserId(email, userType));
    }

    @Test
    public void getUserTypes() throws Exception {
        List<User.UserType> userTypes = UserService.getUserTypes();
        assertNotNull(userTypes);
        assertTrue(userTypes.contains(User.UserType.EMPLOYEE));
        assertTrue(userTypes.contains(User.UserType.EMPLOYER));
        assertTrue(userTypes.size() == 2);
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

    @Test
    public void getUserId() throws Exception {
        int userId = userService.getUserId(email, userType);    //throws an exception when user cannot be found
        assertNotNull(userId);
    }

    @Test
    public void promoteUser() throws Exception {
        userService.promoteUser(email, userType);
        assertTrue(new AuthenticationService().isUserAdmin(email, userType));
    }

    @Test
    public void demoteUser() throws Exception {
        userService.demoteUser(email, userType);
        assertFalse(new AuthenticationService().isUserAdmin(email, userType));
    }

    @Test
    public void changeUserInfo() throws Exception {
        String newName = "Eduard";
        String newSurname = "Khil";
        String about = "Khil became known to international audiences in 2010 when a 1976 recording of him singing a " +
                "non-lexical vocable version of the song \"I am very glad, as I'm finally returning back home\" " +
                "(Я очень рад, ведь я, наконец, возвращаюсь домой) became an Internet meme, often referred to as " +
                "\"Trololol\",[1] or \"Trololo\" as an onomatopoeia of the song, or the \"Russian Rickroll\". ";
        String contactInfo = "Smolensk, Western Oblast, Russian SFSR, Soviet Union";
        byte[] avatar = new byte[]{15, 22};
        userService.changeUserInfo(email, userType, newName, newSurname, about, contactInfo, avatar);
        User user = userService.getUser(email, userType);
        assertEquals(newName, user.getName());
        assertEquals(newSurname, user.getSurname());
        assertEquals(about, user.getAbout());
        assertEquals(contactInfo, user.getContactInfo());
        assertTrue(Arrays.equals(avatar, user.getAvatar()));
    }

    @Test
    public void getAllUsers() throws Exception {
        List<User> users = userService.getAllUsers();
        assertNotNull(users);
        assertTrue(users.size() > 0);
    }


}
