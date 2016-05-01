package com.github.hirethem.model.service;

import com.github.hirethem.model.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

/**
 * Created by egorshulga on 01-May-16.
 */
public class WorkExperienceServiceTest {
    private UserService userService;
    private ResumeService resumeService;
    private WorkExperienceService workExperienceService;

    private String email = "mr@ololo.com";
    private String password = "ololo";
    private String name = "Mr";
    private String surname = "Ololo";
    private User.UserType userType = User.UserType.EMPLOYEE;

    private String summary = "•\tC/C++/C#/Web programmer.\n" +
            "•\tHas a good operational command of an English language.\n";
    private String resumeDescription = "";
    private String skills = "C/C++, C#, Java, Delphi, Assembler i80x86, HTML, PHP.";
    private String interests = "Ololo ololo";
    private String contactInfo = "+375 44 1234567";
    private String references = "Nikita Dubko mefody93@gmail.com";

    private String university = "БГУИР";
    private Date startDate = new Date(2013, 9, 1);
    private Date endDate = new Date(2017, 6, 30);
    private String specialty = "ПОИТ";
    private String degree = "Студент";
    private String description = "обучается";

    private String nothing = "nothing";

    private int userId;
    private int resumeId;
    private int workExperienceId;

    @Before
    public void setUp() throws Exception {
        userService = new UserService();
        resumeService = new ResumeService();
        workExperienceService = new WorkExperienceService();

        userService.createNewUser(email, userType, name, surname, password);
        userId = userService.getUserId(email, userType);
        resumeService.createResume(userId, summary, resumeDescription, skills, interests, contactInfo, references);
        resumeId = resumeService.findResumesUsingSummary(summary).get(0).getId();
        workExperienceService.createWorkExperience(resumeId, university, startDate, endDate, specialty, degree, description);
        workExperienceId = workExperienceService.getWorkExperiences(resumeId).get(0).getId();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void createWorkExperience() throws Exception {

    }

    @Test
    public void modifyWorkExperience() throws Exception {

    }

    @Test
    public void getWorkExperience() throws Exception {

    }

    @Test
    public void getWorkExperiences() throws Exception {

    }

    @Test
    public void deleteWorkExperience() throws Exception {

    }

}