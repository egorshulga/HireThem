package com.github.hirethem.model.util;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by Kirill on 03.05.2016.
 */
public class SVNGenerationUtilTest {

    @Before
    public void setUp() throws Exception {
        new File("test").mkdir();
    }

    @Test
    public void getVacanciesListReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\vacancies-report.csv");
        SVNGenerationUtil.generateVacanciesInCSV().writeTo(stream);
    }

    @Test
    public void getUsersListReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\users-report.csv");
        SVNGenerationUtil.generateUsersInCSV().writeTo(stream);
    }

    @Test
    public void getResumesListReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\resumes-report.csv");
        SVNGenerationUtil.generateResumesInCSV().writeTo(stream);
    }

    @Test
    public void getResumeListReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\test-resume.csv");
        SVNGenerationUtil.generateResumeInCSV(475).writeTo(stream);
    }

    @Test
    public void getVacancyListReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\test-vacancy.csv");
        SVNGenerationUtil.generateVacancyInCSV(166).writeTo(stream);
    }

}
