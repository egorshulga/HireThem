package com.github.hirethem.model.service;

import com.github.hirethem.model.entity.Resume;
import com.github.hirethem.model.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by egorshulga on 30-Apr-16.
 */
public class ResumeServiceTest {
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

    int userId;

    @Before
    public void setUp() throws Exception {
        userService = new UserService();
        resumeService = new ResumeService();
        userService.createNewUser(email, userType, name, surname, password);
        userId = userService.getUserId(email, userType);
        resumeService.createResume(userId, summary, description, skills, interests, contactInfo, references);
    }

    @Test
    public void modifyResume() throws Exception {
        String nothing = "nothing";
        int resumeId = resumeService.findResumesUsingInterests("Ololo ololo").get(0).getId();
        resumeService.modifyResume(resumeId, nothing, nothing, nothing, nothing, nothing, nothing);
        Resume resume = resumeService.findResumesUsingSummary(nothing).get(0);
        assertEquals(resume.getSummary(), nothing);
        assertEquals(resume.getDescription(), nothing);
        assertEquals(resume.getSkills(), nothing);
        assertEquals(resume.getInterests(), nothing);
        assertEquals(resume.getContactInfo(), nothing);
        assertEquals(resume.getReferences(), nothing);
    }

    @Test
    public void getResume() throws Exception {
        Resume resume = resumeService.findResumesUsingInterests("Ololo ololo").get(0);
        assertNotNull(resume);
        assertEquals(resume.getContactInfo(), contactInfo);
        assertEquals(resume.getDescription(), description);
        assertNotNull(resume.getEducations());
        assertEquals(resume.getEmployee().getId(), userService.getUserId(email, userType));
        assertEquals(resume.getSkills(), skills);
        assertEquals(resume.getInterests(), interests);
        assertEquals(resume.getReferences(), references);
        assertEquals(resume.getSummary(), summary);
    }

    @Test
    public void getResumes() throws Exception {
        int userId = userService.getUserId(email, userType);
        List<Resume> resumes = resumeService.getResumes(userId);
        assertNotNull(resumes);
        assertTrue(resumes.size() > 0);
    }

    @Test
    public void findResumesUsingSummary() throws Exception {
        Resume resume = resumeService.findResumesUsingSummary("Web").get(0);
        assertNotNull(resume);
        assertTrue(StringUtils.contains(resume.getSummary(), "Web"));
    }

    @Test
    public void findResumesUsingDescription() throws Exception {
        Resume resume = resumeService.findResumesUsingDescription("").get(0);
        assertNotNull(resume);
        assertTrue(StringUtils.contains(resume.getSummary(), ""));
    }

    @Test
    public void findResumesUsingSkills() throws Exception {
        Resume resume = resumeService.findResumesUsingSkills("Java").get(0);
        assertNotNull(resume);
        assertTrue(StringUtils.containsIgnoreCase(resume.getSkills(), "Java"));
    }

    @Test
    public void findResumesUsingInterests() throws Exception {
        Resume resume = resumeService.findResumesUsingInterests("ol").get(0);
        assertNotNull(resume);
        assertTrue(StringUtils.contains(resume.getInterests(), "ol"));
    }

    @After
    public void tearDown() throws Exception {
        userService.deleteUser(userService.getUserId(email, userType));
    }

}