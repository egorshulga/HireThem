package com.github.hirethem.model.service;

import com.github.hirethem.model.dao.ResumeDao;
import com.github.hirethem.model.entity.Resume;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by egorshulga on 30-Apr-16.
 */
public class ResumeService {

    private UserService userService = new UserService();

    private ResumeDao resumeDao = new ResumeDao();

    public void createResume(int userId, String summary, String description, String skills, String interests,
                             String contactInfo, String references) throws ServiceException {
        Resume resume = new Resume();
        resume.setSummary(summary);
        resume.setDescription(description);
        resume.setSkills(skills);
        resume.setInterests(interests);
        resume.setReferences(references);
        resume.setContactInfo(contactInfo);

        User currentUser = userService.getUser(userId);

        resume.setEmployee(currentUser);

        resumeDao.addResume(currentUser, resume);
    }

    public void modifyResume(int resumeId, String summary, String description, String skills, String interests,
                             String contactInfo, String references) {
        resumeDao.modifyResume(resumeId, summary, description, skills, interests, contactInfo, references);
    }

    public Resume getResume(int resumeId) {
        return resumeDao.getResume(resumeId);
    }

    public List<Resume> getResumes(int userId) throws ServiceException {
        return resumeDao.getResumes(userService.getUser(userId));
    }

    public void deleteResume(int resumeId) {
        resumeDao.deleteResume(resumeId);
    }

    public List<Resume> findResumesUsingSummary(String searchText) {
        return resumeDao.getAllResumes().stream()
                .filter(resume -> StringUtils.containsIgnoreCase(resume.getSummary(), searchText))
                .collect(Collectors.toList());
    }

    public List<Resume> findResumesUsingDescription(String searchText) {
        return resumeDao.getAllResumes().stream()
                .filter(resume -> StringUtils.containsIgnoreCase(resume.getDescription(), searchText))
                .collect(Collectors.toList());
    }

    public List<Resume> findResumesUsingSkills(String searchText) {
        return resumeDao.getAllResumes().stream()
                .filter(resume -> StringUtils.containsIgnoreCase(resume.getSkills(), searchText))
                .collect(Collectors.toList());
    }

    public List<Resume> findResumesUsingInterests(String searchText) {
        return resumeDao.getAllResumes().stream()
                .filter(resume -> StringUtils.containsIgnoreCase(resume.getInterests(), searchText))
                .collect(Collectors.toList());
    }

    public List<Resume> getAllResumes() {
        return resumeDao.getAllResumes();
    }
}
