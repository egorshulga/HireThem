package com.github.hirethem.model.dao;

import com.github.hirethem.model.entity.Resume;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.entity.WorkExperience;
import com.github.hirethem.model.service.ResumeService;
import com.github.hirethem.model.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by egorshulga on 01-May-16.
 */
public class WorkExperienceDaoTest {
    private UserService userService;
    private ResumeService resumeService;
    private WorkExperienceDao workExperienceDao;

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

    private User user;
    private Resume resume;
    private WorkExperience workExperience;


    @Before
    public void setUp() throws Exception {
        userService = new UserService();
        resumeService = new ResumeService();
        workExperienceDao = new WorkExperienceDao();

        userService.createNewUser(email, userType, name, surname, password);
        user = userService.getUser(email, userType);
        resumeService.createResume(user.getId(), summary, resumeDescription, skills, interests, contactInfo, references);
        resume = resumeService.findResumesUsingSummary(summary).get(0);
        workExperience = new WorkExperience();
        workExperience.setCompanyName(companyName);
        workExperience.setPosition(position);
        workExperience.setStartDate(startDate);
        workExperience.setEndDate(endDate);
        workExperience.setDescription(description);
        workExperience.setResume(resume);
        workExperienceDao.addWorkExperience(resume, workExperience);
        workExperience = workExperienceDao.getWorkExperiences(resume).get(0);
    }

    @After
    public void tearDown() throws Exception {
        userService.deleteUser(user.getId());
    }

    @Test
    public void modifyWorkExperience() throws Exception {
        workExperienceDao.modifyWorkExperience(workExperience.getId(), nothing, nothing, endDate, endDate, nothing);
        WorkExperience workExperience = workExperienceDao.getWorkExperience(this.workExperience.getId());
        assertEquals(workExperience.getCompanyName(), nothing);
        assertEquals(workExperience.getDescription(), nothing);
        assertEquals(workExperience.getStartDate(), endDate);
        assertEquals(workExperience.getEndDate(), endDate);
        assertEquals(workExperience.getPosition(), nothing);
    }

    @Test
    public void getWorkExperience() throws Exception {
        WorkExperience workExperience = workExperienceDao.getWorkExperience(this.workExperience.getId());
        assertNotNull(workExperience);
    }

    @Test
    public void getWorkExperiences() throws Exception {
        List<WorkExperience> workExperiences = workExperienceDao.getWorkExperiences(resume);
        assertTrue(workExperiences.size() > 0);
    }

}