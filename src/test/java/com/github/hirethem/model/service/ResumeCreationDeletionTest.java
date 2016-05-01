package com.github.hirethem.model.service;

import com.github.hirethem.model.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by egorshulga on 01-May-16.
 */
public class ResumeCreationDeletionTest {
    private UserService userService;
    private ResumeService resumeService;

    private String email = "mr@ololo.com";
    private String password = "ololo";
    private String name = "Mr";
    private String surname = "Ololo";
    private User.UserType userType = User.UserType.EMPLOYEE;

    private String summary = "•\tC/C++/C#/Web programmer.\n" +
            "•\tHas a good operational command of an English language.\n";
    private String description = "";
    private String skills = "C/C++, C#, Java, Delphi, Assembler i80x86, HTML, PHP.";
    private String interests = "Ololo ololo";
    private String contactInfo = "+375 44 1234567";
    private String references = "Nikita Dubko mefody93@gmail.com";

    @Before
    public void setUp() throws Exception {
        userService = new UserService();
        resumeService = new ResumeService();
        userService.createNewUser(email, userType, name, surname, password);

    }

    @After
    public void tearDown() throws Exception {
        userService.deleteUser(email, userType);
    }

    @Test
    public void createResume() throws Exception {
        resumeService.createResume(userService.getUserId(email, userType),
                summary, description, skills, interests, contactInfo, references);
    }

    @Test
    public void deletePresentResume() throws Exception {
        createResume();
        resumeService.deleteResume(resumeService.findResumesUsingSummary(summary).get(0).getId());
    }
}
