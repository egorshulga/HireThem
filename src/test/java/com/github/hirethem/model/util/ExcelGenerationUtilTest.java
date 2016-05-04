package com.github.hirethem.model.util;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by Kirill on 03.05.2016.
 */
public class ExcelGenerationUtilTest {
    @Before
    public void setUp() throws Exception {
        new File("test").mkdir();
    }

    @Test
    public void getVacanciesListReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\vacancies-report.xls");
        ExcelGenerationUtil.generateVacanciesInXLS().writeTo(stream);
    }

    @Test
    public void getUsersReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\users.xls");
        ExcelGenerationUtil.generateUsersInXLS().writeTo(stream);
    }

    @Test
    public void getResumesReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\resumes.xls");
        ExcelGenerationUtil.generateResumesInXLS().writeTo(stream);
    }

    @Test
    public void getResumeReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\test-resume.xls");
        ExcelGenerationUtil.generateResumeInXLS(475).writeTo(stream);
    }

    @Test
    public void getVacancyReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\test-vacancy.xls");
        ExcelGenerationUtil.generateVacancyInXLS(166).writeTo(stream);
    }
}
