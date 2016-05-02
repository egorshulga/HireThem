package com.github.hirethem.model.util;

import com.github.hirethem.model.entity.Resume;
import com.github.hirethem.model.service.ResumeService;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by egorshulga on 02-May-16.
 */
public class PdfGenerationUtilTest {

    @Test
    public void createResumeDocument() throws Exception {
        Resume resume = new ResumeService().getAllResumes().get(0);

        OutputStream stream = new FileOutputStream("sample-resume.pdf");
        PdfGenerationUtil.createResumeDocument(resume).writeTo(stream);
    }

}