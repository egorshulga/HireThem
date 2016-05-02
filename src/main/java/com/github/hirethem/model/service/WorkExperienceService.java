package com.github.hirethem.model.service;

import com.github.hirethem.model.dao.WorkExperienceDao;
import com.github.hirethem.model.entity.WorkExperience;
import com.github.hirethem.model.entity.Resume;
import com.github.hirethem.model.service.exception.ServiceException;

import java.sql.Date;
import java.util.List;

/**
 * Created by egorshulga on 01-May-16.
 */
public class WorkExperienceService {

    private ResumeService resumeService = new ResumeService();

    private WorkExperienceDao workExperienceDao = new WorkExperienceDao();

    public void createWorkExperience(int resumeId, String companyName, String position,
                                     Date startDate, Date endDate, String description) throws ServiceException {
        WorkExperience workExperience = new WorkExperience();
        workExperience.setCompanyName(companyName);
        workExperience.setPosition(position);
        workExperience.setStartDate(startDate);
        workExperience.setEndDate(endDate);
        workExperience.setDescription(description);

        Resume resume = resumeService.getResume(resumeId);

        workExperience.setResume(resume);

        workExperienceDao.addWorkExperience(resume, workExperience);
    }

    public void modifyWorkExperience(int resumeId, String companyName, String position,
                                     Date startDate, Date endDate, String description) {
        workExperienceDao.modifyWorkExperience(resumeId, companyName, position,
                startDate, endDate, description);
    }

    public WorkExperience getWorkExperience(int workExperienceId) {
        return workExperienceDao.getWorkExperience(workExperienceId);
    }

    public List<WorkExperience> getWorkExperiences(int resumeId) {
        return workExperienceDao.getWorkExperiences(resumeService.getResume(resumeId));
    }

    public void deleteWorkExperience(int workExperienceId) {
        workExperienceDao.deleteWorkExperience(workExperienceId);
    }


}
