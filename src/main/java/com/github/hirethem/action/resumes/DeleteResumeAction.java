package com.github.hirethem.action.resumes;

import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.CurrentUserService;
import com.github.hirethem.model.service.ResumeService;
import com.github.hirethem.model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by egorshulga on 12-May-16.
 */
public class DeleteResumeAction extends ActionSupport {

    protected int resumeId;

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

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }


}
