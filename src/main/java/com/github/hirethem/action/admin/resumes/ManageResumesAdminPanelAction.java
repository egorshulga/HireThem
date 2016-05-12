package com.github.hirethem.action.admin.resumes;

import com.github.hirethem.action.interceptor.AuthorizeAs;
import com.github.hirethem.action.resumes.ManageResumesAction;
import com.github.hirethem.model.service.ResumeService;

/**
 * Created by egorshulga on 12-May-16.
 */
@AuthorizeAs(admin = true)
public class ManageResumesAdminPanelAction extends ManageResumesAction {

    public String execute() {
        resumes = new ResumeService().getAllResumes();
        return SUCCESS;
    }

}
