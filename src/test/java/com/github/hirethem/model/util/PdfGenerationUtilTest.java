package com.github.hirethem.model.util;

import com.github.hirethem.model.entity.Resume;
import com.github.hirethem.model.entity.Vacancy;
import com.github.hirethem.model.service.ResumeService;
import com.github.hirethem.model.service.VacancyService;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by egorshulga on 02-May-16.
 */
public class PdfGenerationUtilTest {



    @Before
    public void setUp() throws Exception {
        new File("test").mkdir();
    }

    @Test
    public void getResumeDocument() throws Exception {
        Resume resume = new ResumeService().getAllResumes().get(0);

        OutputStream stream = new FileOutputStream("test\\test-resume.pdf");
        PdfGenerationUtil.getResumeDocument(resume).writeTo(stream);
    }

    @Test
    public void getVacancyDocument() throws Exception {
        Vacancy vacancy = new VacancyService().getAllVacancies().get(0);

        OutputStream stream = new FileOutputStream("test\\test-vacancy.pdf");
        PdfGenerationUtil.getVacancyDocument(vacancy).writeTo(stream);
    }

    @Test
    public void getUsersReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\users-report.pdf");
        PdfGenerationUtil.getUsersReport().writeTo(stream);
    }

    @Test
    public void getResumesReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\resumes-report.pdf");
        PdfGenerationUtil.getResumesReport().writeTo(stream);
    }

    @Test
    public void getVacanciesReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\vacancies-report.pdf");
        PdfGenerationUtil.getVacanciesReport().writeTo(stream);
    }

}