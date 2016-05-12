package com.github.hirethem.action.resumes;

import com.github.hirethem.model.service.ResumeService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by egorshulga on 12-May-16.
 */
public class DeleteResumeAction extends ActionSupport {

    private int resumeId;

    public String execute() {
        new ResumeService().deleteResume(resumeId);
        return SUCCESS;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }
}
