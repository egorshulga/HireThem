package com.github.hirethem.model.service;

import com.github.hirethem.model.dao.EducationDao;
import com.github.hirethem.model.entity.Education;
import com.github.hirethem.model.entity.Resume;
import com.github.hirethem.model.service.exception.ServiceException;

import java.sql.Date;
import java.util.List;

/**
 * Created by egorshulga on 01-May-16.
 */
public class EducationService {

    private ResumeService resumeService = new ResumeService();

    private EducationDao educationDao = new EducationDao();

    public void createEducation(int resumeId, String university, Date startDate, Date endDate,
                                String specialty, String degree, String description) throws ServiceException {

        Education education = new Education();
        education.setUniversity(university);
        education.setStartDate(startDate);
        education.setEndDate(endDate);
        education.setSpecialty(specialty);
        education.setDegree(degree);
        education.setDescription(description);

        Resume resume = resumeService.getResume(resumeId);

        education.setResume(resume);

        educationDao.addEducation(resume, education);
    }

    public void modifyEducation(int resumeId, String university, Date startDate, Date endDate,
                                String specialty, String degree, String description) {
        educationDao.modifyEducation(resumeId, university, startDate, endDate, specialty, degree,
                description);
    }

    public Education getEducation(int educationId) {
        return educationDao.getEducation(educationId);
    }

    public List<Education> getVacancies(int userId) {
        return educationDao.getEducations(userId);
    }

    public void deleteEducation(int educationId) {
        educationDao.deleteEducation(educationId);
    }


}
