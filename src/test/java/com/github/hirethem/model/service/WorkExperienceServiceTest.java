package com.github.hirethem.model.service;

import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.entity.WorkExperience;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

    private String companyName = "БГУИР";
    private String position = "мнс";
    private Date startDate = new Date(2013, 9, 1);
    private Date endDate = new Date(2017, 6, 30);
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
        resumeService.createResume(userId, summary, resumeDescription, skills, interests, references);
        resumeId = resumeService.findResumesUsingSummary(summary).get(0).getId();
        workExperienceService.createWorkExperience(resumeId, companyName, position, startDate, endDate, description);
        workExperienceId = workExperienceService.getWorkExperiences(resumeId).get(0).getId();

    }

    @After
    public void tearDown() throws Exception {
        userService.deleteUser(userId);
    }

    @Test
    public void createWorkExperience() throws Exception {
        workExperienceService.deleteWorkExperience(workExperienceId);
        workExperienceService.createWorkExperience(resumeId, companyName, position, startDate, endDate, description);
        WorkExperience workExperience = workExperienceService.getWorkExperiences(resumeId).get(0);
        assertNotNull(workExperience);
    }

    @Test
    public void modifyWorkExperience() throws Exception {
        workExperienceService.modifyWorkExperience(workExperienceId, nothing, nothing, endDate, endDate, nothing);
        WorkExperience workExperience = workExperienceService.getWorkExperience(workExperienceId);
        assertEquals(workExperience.getCompanyName(), nothing);
        assertEquals(workExperience.getDescription(), nothing);
        assertEquals(workExperience.getStartDate(), endDate);
        assertEquals(workExperience.getEndDate(), endDate);
        assertEquals(workExperience.getPosition(), nothing);
    }

    @Test
    public void getWorkExperience() throws Exception {
        WorkExperience workExperience = workExperienceService.getWorkExperience(workExperienceId);
        assertNotNull(workExperience);
    }

    @Test
    public void getWorkExperiences() throws Exception {
        List<WorkExperience> workExperiences = workExperienceService.getWorkExperiences(resumeId);
        assertTrue(workExperiences.size() > 0);
    }

    @Test
    public void deleteWorkExperience() throws Exception {
        workExperienceService.deleteWorkExperience(workExperienceId);
        assert(workExperienceService.getWorkExperiences(resumeId).size() == 0);
    }

}