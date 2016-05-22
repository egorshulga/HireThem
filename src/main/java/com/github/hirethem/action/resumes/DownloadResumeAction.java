package com.github.hirethem.action.resumes;

import com.github.hirethem.model.service.ResumeService;
import com.github.hirethem.model.util.CsvGenerationUtil;
import com.github.hirethem.model.util.PdfGenerationUtil;
import com.github.hirethem.model.util.XlsGenerationUtil;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by egorshulga on 22-May-16.
 */
public class DownloadResumeAction extends ActionSupport {

    private ResumeService resumeService = new ResumeService();

    private int id;
    private InputStream stream;

    public String downloadPdf() {
        try {
            stream = new ByteArrayInputStream(PdfGenerationUtil.getResumeDocument(resumeService.getResume(id)).toByteArray());
            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }
    }

    public String downloadCsv() {
        try {
            stream = new ByteArrayInputStream(CsvGenerationUtil.generateResumeInCSV(id).toByteArray());
            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }
    }

    public String downloadXls() {
        try {
            stream = new ByteArrayInputStream(XlsGenerationUtil.generateResumeInXls(id).toByteArray());
            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InputStream getStream() {
        return stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }
}
