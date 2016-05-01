package com.github.hirethem.model.entity;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by egorshulga on 01-May-16.
 */
public class EducationTest {

    private Education education;

    private String university = "БГУИР";
    private Date startDate = new Date(2013, 9, 1);
    private Date endDate = new Date(2017, 6, 30);
    private String specialty = "ПОИТ";
    private String degree = "Студент";
    private String description = "обучается";


    @Before
    public void setUp() throws Exception {
        education = new Education();
        education.setResume(new Resume());
        education.setUniversity(university);
        education.setStartDate(startDate);
        education.setEndDate(endDate);
        education.setSpecialty(specialty);
        education.setDegree(degree);
        education.setDescription(description);
    }

    @Test
    public void getId() throws Exception {
        assertNotNull(education.getId());
    }

    @Test
    public void getResume() throws Exception {
        assertNotNull(education.getResume());
    }

    @Test
    public void getUniversity() throws Exception {
        assertEquals(education.getUniversity(), university);
    }

    @Test
    public void getStartDate() throws Exception {
        assertEquals(education.getStartDate(), startDate);
    }

    @Test
    public void getEndDate() throws Exception {
        assertEquals(education.getEndDate(), endDate);
    }

    @Test
    public void getSpecialty() throws Exception {
        assertEquals(education.getSpecialty(), specialty);
    }

    @Test
    public void getDegree() throws Exception {
        assertEquals(education.getDegree(), degree);
    }

    @Test
    public void getDescription() throws Exception {
        assertEquals(education.getDescription(), description);
    }

}