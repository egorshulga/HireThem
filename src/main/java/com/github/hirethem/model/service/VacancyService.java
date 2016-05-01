package com.github.hirethem.model.service;

import com.github.hirethem.model.dao.VacancyDao;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.entity.Vacancy;
import com.github.hirethem.model.service.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by egorshulga on 30-Apr-16.
 */
public class VacancyService {

    private UserService userService = new UserService();
    private VacancyDao vacancyDao = new VacancyDao();

    public void createVacancy(int userId, String title, String summary, String description,
                              String salary, String requiredExperience, String requiredSkills,
                              String contactInfo) throws ServiceException {
        Vacancy vacancy = new Vacancy();
        vacancy.setTitle(title);
        vacancy.setSummary(summary);
        vacancy.setDescription(description);
        vacancy.setSalary(salary);
        vacancy.setRequiredExperience(requiredExperience);
        vacancy.setRequiredSkills(requiredSkills);
        vacancy.setContactInfo(contactInfo);

        User currentUser = userService.getUser(userId);

        vacancy.setEmployer(currentUser);

        vacancyDao.addVacancy(currentUser, vacancy);
    }

    public void modifyVacancy(int vacancyId, String title, String summary, String description,
                              String salary, String requiredExperience, String requiredSkills,
                              String contactInfo) {
        vacancyDao.modifyVacancy(vacancyId, title, summary, description, salary, requiredExperience,
                requiredSkills, contactInfo);
    }

    public Vacancy getVacancy(int vacancyId) {
        return vacancyDao.getVacancy(vacancyId);
    }

    public List<Vacancy> getVacancies(int userId) throws ServiceException {
        return vacancyDao.getVacancies(userService.getUser(userId));
    }

    public void deleteVacancy(int vacancyId) {
        vacancyDao.deleteVacancy(vacancyId);
    }


    public List<Vacancy> findVacanciesUsingTitle(String searchText) {
        return vacancyDao.getAllVacancies().stream()
                .filter(vacancy -> StringUtils.containsIgnoreCase(vacancy.getTitle(), searchText))
                .collect(Collectors.toList());
    }

    public List<Vacancy> findVacanciesUsingSummary(String searchText) {
        return vacancyDao.getAllVacancies().stream()
                .filter(vacancy -> StringUtils.containsIgnoreCase(vacancy.getSummary(), searchText))
                .collect(Collectors.toList());
    }

    public List<Vacancy> findResumesUsingDescription(String searchText) {
        return vacancyDao.getAllVacancies().stream()
                .filter(vacancy -> StringUtils.containsIgnoreCase(vacancy.getDescription(), searchText))
                .collect(Collectors.toList());
    }

    public List<Vacancy> findResumesUsingRequiredSkills(String searchText) {
        return vacancyDao.getAllVacancies().stream()
                .filter(vacancy -> StringUtils.containsIgnoreCase(vacancy.getRequiredSkills(), searchText))
                .collect(Collectors.toList());
    }

    public List<Vacancy> findResumesUsingRequiredExperience(String searchText) {
        return vacancyDao.getAllVacancies().stream()
                .filter(vacancy -> StringUtils.containsIgnoreCase(vacancy.getRequiredExperience(), searchText))
                .collect(Collectors.toList());
    }

    public List<Vacancy> getAllVacancies() {
        return vacancyDao.getAllVacancies();
    }


}
