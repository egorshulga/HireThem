package com.github.hirethem.model.util;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by Kirill on 03.05.2016.
 */
public class CsvGenerationUtilTest {

    @Before
    public void setUp() throws Exception {
        new File("test").mkdir();
    }

    @Test
    public void getVacanciesListReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\vacancies-report.csv");
        CsvGenerationUtil.generateVacanciesInCSV().writeTo(stream);
    }

    @Test
    public void getUsersListReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\users-report.csv");
        CsvGenerationUtil.generateUsersInCSV().writeTo(stream);
    }

    @Test
    public void getResumesListReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\resumes-report.csv");
        CsvGenerationUtil.generateResumesInCSV().writeTo(stream);
    }

    @Test
    public void getResumeListReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\test-resume.csv");
        CsvGenerationUtil.generateResumeInCSV(475).writeTo(stream);
    }

    @Test
    public void getVacancyListReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\test-vacancy.csv");
        CsvGenerationUtil.generateVacancyInCSV(166).writeTo(stream);
    }

}
