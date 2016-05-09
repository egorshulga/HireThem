package com.github.hirethem.action.vacancies;

import com.github.hirethem.model.entity.Vacancy;
import com.github.hirethem.model.service.VacancyService;

/**
 * Created by egorshulga on 06-May-16.
 */
public class ModifyVacancyAction extends AuthorizationRequired{

    private String title;
    private String summary;
    private String description;
    private String salary;
    private String requiredExperience;
    private String requiredSkills;

    private int vacancyId;

    public String input() {
        Vacancy vacancy = new VacancyService().getVacancy(vacancyId);
        title = vacancy.getTitle();
        summary = vacancy.getSummary();
        description = vacancy.getDescription();
        salary = vacancy.getSalary();
        requiredExperience = vacancy.getRequiredExperience();
        requiredSkills = vacancy.getRequiredSkills();
        return INPUT;
    }

    public String execute() {
        new VacancyService().modifyVacancy(vacancyId, title, summary, description, salary, requiredExperience, requiredSkills);
        return SUCCESS;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
    }
}
