package com.github.hirethem.model.dao;

import com.github.hirethem.model.entity.Resume;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.ResumeService;
import com.github.hirethem.model.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by egorshulga on 01-May-16.
 */
public class ResumeDaoTest {

    private ResumeDao resumeDao;

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

    private int resumeId;
    User user;

    private String nothing = "nothing";

    @Before
    public void setUp() throws Exception {
        resumeDao = new ResumeDao();
        Resume resume = new Resume();
        resume.setSummary(summary);
        resume.setDescription(description);
        resume.setSkills(skills);
        resume.setInterests(interests);
        resume.setContactInfo(contactInfo);
        resume.setReferences(references);

        userService = new UserService();
        resumeService = new ResumeService();
        userService.createNewUser(email, userType, name, surname, password);
        user = userService.getUser(email, userType);
        resume.setEmployee(user);
        resumeDao.addResume(user, resume);
        resumeId = resumeDao.getResumes(user).get(0).getId();
    }

    @After
    public void tearDown() throws Exception {
        userService.deleteUser(user.getId());
    }

    @Test
    public void modifyResume() throws Exception {
        resumeDao.modifyResume(resumeId, nothing, nothing, nothing, nothing, nothing, nothing);
        Resume resume = resumeDao.getResume(resumeId);
        assertEquals(resume.getSummary(), nothing);
        assertEquals(resume.getDescription(), nothing);
        assertEquals(resume.getSkills(), nothing);
        assertEquals(resume.getInterests(), nothing);
        assertEquals(resume.getContactInfo(), nothing);
        assertEquals(resume.getReferences(), nothing);
    }

    @Test
    public void getResume() throws Exception {
        Resume resume = resumeDao.getResume(resumeId);
        assertNotNull(resume);
    }

    @Test
    public void getResumes() throws Exception {
        List<Resume> resumes = resumeDao.getResumes(user);
        assertTrue(resumes.size() > 0);
    }

    @Test
    public void getAllResumes() throws Exception {
        List<Resume> resumes = resumeDao.getAllResumes();
        assertTrue(resumes.size() > 0);
    }

}