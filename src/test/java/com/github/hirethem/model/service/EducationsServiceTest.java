package com.github.hirethem.model.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by egorshulga on 01-May-16.
 */
public class EducationsServiceTest {
    private UserService userService;
    private EducationsService educationsService;

    @Before
    public void setUp() throws Exception {
        userService = new UserService();
        educationsService = new EducationsService();

//        userService.createNewUser("mr@ololo.com", User.UserType.EMPLOYER);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void createEducation() throws Exception {

    }

    @Test
    public void modifyEducation() throws Exception {

    }

    @Test
    public void getEducation() throws Exception {

    }

    @Test
    public void getEducations() throws Exception {

    }

    @Test
    public void deleteEducation() throws Exception {

    }
}