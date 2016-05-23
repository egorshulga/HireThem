package com.github.hirethem.action.resumes;

import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.CurrentUserService;
import com.github.hirethem.model.service.ResumeService;
import com.github.hirethem.model.service.exception.ServiceException;
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

    private int resumeId;
    private InputStream stream;

    public String downloadPdf() {
        try {
            stream = new ByteArrayInputStream(PdfGenerationUtil.getResumeDocument(resumeService.getResume(resumeId)).toByteArray());
        } catch (Exception e) {
        }
        return SUCCESS;
    }

    public String downloadCsv() {
        try {
            stream = new ByteArrayInputStream(CsvGenerationUtil.generateResumeInCSV(resumeId).toByteArray());
        } catch (Exception e) {
        }
        return SUCCESS;
    }

    public String downloadXls() {
        try {
            stream = new ByteArrayInputStream(XlsGenerationUtil.generateResumeInXls(resumeId).toByteArray());
        } catch (Exception e) {
        }
        return SUCCESS;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public InputStream getStream() {
        return stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }


}
