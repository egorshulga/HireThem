package com.github.hirethem.action.vacancies;

import com.github.hirethem.model.service.CurrentUserService;
import com.github.hirethem.model.service.VacancyService;
import com.github.hirethem.model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by egorshulga on 06-May-16.
 */
public class CreateVacancyAction extends ActionSupport {

    private String title;
    private String summary;
    private String description;
    private String salary;
    private String requiredExperience;
    private String requiredSkills;

    public String execute() {
        try {
            int userId = new CurrentUserService().getCurrentUserId();
            new VacancyService().createVacancy(userId, title, summary, description, salary, requiredExperience, requiredSkills);
        } catch (ServiceException ignored) {
        }
        return SUCCESS;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getRequiredExperience() {
        return requiredExperience;
    }

    public void setRequiredExperience(String requiredExperience) {
        this.requiredExperience = requiredExperience;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }
}
