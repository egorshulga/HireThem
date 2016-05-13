package com.github.hirethem.action.vacancies;

import com.github.hirethem.action.interceptor.AuthorizeAs;
import com.github.hirethem.model.entity.Vacancy;
import com.github.hirethem.model.service.SessionService;
import com.github.hirethem.model.service.VacancyService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by egorshulga on 06-May-16.
 */
@AuthorizeAs(userType = "EMPLOYER")
public class ModifyVacancyAction extends ActionSupport {

    private String title;
    private String summary;
    private String description;
    private String salary;
    private String requiredExperience;
    private String requiredSkills;

    private int vacancyId;

    public String input() {
        vacancyId = (int) new SessionService().getValue("chosenVacancyId");
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

    public void validate() {
        if (StringUtils.isEmpty(title)) {
            addActionError("Title cannot be empty");
        }
        if (StringUtils.isEmpty(summary)) {
            addActionError("Summary cannot be empty");
        }
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
