package com.github.hirethem.action.resumes;

import com.github.hirethem.model.entity.Resume;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.CurrentUserService;
import com.github.hirethem.model.service.ResumeService;
import com.github.hirethem.model.service.exception.ServiceException;

import java.util.List;

/**
 * Created by egorshulga on 06-May-16.
 */
public class ManageResumesAction extends AuthorizationRequired {

    private List<Resume> resumes;
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
