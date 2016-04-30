package com.github.hirethem.model.service;

import com.github.hirethem.model.dao.ResumeDao;
import com.github.hirethem.model.entity.Resume;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.exception.ServiceException;

import java.util.List;

/**
 * Created by egorshulga on 30-Apr-16.
 */
public class ResumeService {

    private UserService userService = new UserService();

    private ResumeDao resumeDao = new ResumeDao();

    public void createResume(int userId, String summary, String description, String skills, String interests,
                             String references) throws ServiceException {
        Resume resume = new Resume();
        resume.setSummary(summary);
        resume.setDescription(description);
        resume.setSkills(skills);
        resume.setInterests(interests);
        resume.setReferences(references);

        User currentUser = userService.getUser(userId);

        resume.setEmployee(currentUser);

        resumeDao.addResume(currentUser, resume);
    }

    public void modifyResume(int resumeId, String summary, String description, String skills, String interests,
                             String references) {
        resumeDao.modifyResume(resumeId, summary, description, skills, interests, references);
    }

    public Resume getResume(int resumeId) {
        return resumeDao.getResume(resumeId);
    }

    public List<Resume> getResumes(int userId) {
        return resumeDao.getResumes(userId);
    }

    public void deleteResume(int resumeId) {
        resumeDao.deleteResume(resumeId);
    }

}
