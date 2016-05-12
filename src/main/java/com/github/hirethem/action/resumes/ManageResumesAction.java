package com.github.hirethem.action.resumes;

import com.github.hirethem.action.interceptor.AuthorizeAs;
import com.github.hirethem.model.entity.Resume;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.CurrentUserService;
import com.github.hirethem.model.service.ResumeService;
import com.github.hirethem.model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by egorshulga on 06-May-16.
 */
@AuthorizeAs(userType = "EMPLOYEE")
public class ManageResumesAction extends ActionSupport {

    protected List<Resume> resumes;
    private User currentUser;

    public String execute() {
        try {
            currentUser = new CurrentUserService().getCurrentUserEntity();
            resumes = new ResumeService().getResumes(currentUser.getId());
        } catch (ServiceException ignored) {
        }
        return SUCCESS;
    }

    public List<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(List<Resume> resumes) {
        this.resumes = resumes;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
