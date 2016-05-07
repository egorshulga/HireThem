package com.github.hirethem.model.dao;

import com.github.hirethem.model.entity.Education;
import com.github.hirethem.model.entity.Resume;
import com.github.hirethem.model.entity.User;
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
public class EducationDaoTest {
    private EducationDao educationDao;
    private UserService userService;
    private ResumeService resumeService;

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

    private int educationId;
    private User user;
    private Resume resume;

    String nothing  = "nothing";

    @Before
    public void setUp() throws Exception {
        userService = new UserService();
        resumeService = new ResumeService();
        educationDao = new EducationDao();

        userService.createNewUser(email, userType, name, surname, password);
        user = userService.getUser(email, userType);
        resumeService.createResume(user.getId(), summary, resumeDescription, skills, interests, references);
        resume = resumeService.findResumesUsingSummary(summary).get(0);

        educationDao.addEducation(resume, new Education(university, startDate, endDate, specialty, degree, description, resume));
        educationId = educationDao.getEducations(resume).get(0).getId();
    }

    @After
    public void tearDown() throws Exception {
        userService.deleteUser(user.getId());
    }

    @Test
    public void deleteEducation() throws Exception {
        educationDao.deleteEducation(educationId);
    }

    @Test
    public void modifyEducation() throws Exception {
        educationDao.modifyEducation(educationId, nothing, endDate, endDate, nothing, nothing, nothing);
        Education education = educationDao.getEducation(educationId);
        assertEquals(education.getUniversity(), nothing);
        assertEquals(education.getDescription(), nothing);
        assertEquals(education.getStartDate(), endDate);
        assertEquals(education.getEndDate(), endDate);
        assertEquals(education.getDegree(), nothing);
        assertEquals(education.getSpecialty(), nothing);
    }

    @Test
    public void getEducation() throws Exception {
        Education education = educationDao.getEducation(educationId);
        assertEquals(education.getUniversity(), university);
        assertEquals(education.getDescription(), description);
        assertEquals(education.getStartDate(), startDate);
        assertEquals(education.getEndDate(), endDate);
        assertEquals(education.getDegree(), degree);
        assertEquals(education.getSpecialty(), specialty);
    }

    @Test
    public void getEducations() throws Exception {
        List<Education> educations = educationDao.getEducations(resume);
        assertTrue(educations.size() > 0);
    }

}