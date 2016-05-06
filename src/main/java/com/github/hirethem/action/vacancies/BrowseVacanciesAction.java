package com.github.hirethem.action.vacancies;

import com.github.hirethem.action.interceptor.AuthorizationRequired;
import com.github.hirethem.model.entity.Vacancy;
import com.github.hirethem.model.service.VacancyService;

import java.util.List;

/**
 * Created by egorshulga on 06-May-16.
 */
public class BrowseVacanciesAction extends AuthorizationRequired {

    private String titleToSearch;
    private String summaryToSearch;
    private String requiredExperienceToSearch;
    private String requiredSkillsToSearch;

    private List<Vacancy> vacancies;

    public String input() {
        return INPUT;
    }

    public String searchVacanciesByTitle() {
        vacancies = new VacancyService().findResumesUsingTitle(titleToSearch);
        return SUCCESS;
    }

    public String searchVacanciesBySummary() {
        vacancies = new VacancyService().findResumesUsingSummary(summaryToSearch);
        return SUCCESS;
    }

    public String searchVacanciesBySkills() {
        vacancies = new VacancyService().findResumesUsingRequiredSkills(requiredExperienceToSearch);
        return SUCCESS;
    }

    public String searchVacanciesByExperience() {
        vacancies = new VacancyService().findResumesUsingRequiredExperience(requiredSkillsToSearch);
        return SUCCESS;
    }

    public String getTitleToSearch() {
        return titleToSearch;
    }

    public void setTitleToSearch(String titleToSearch) {
        this.titleToSearch = titleToSearch;
    }

    public String getSummaryToSearch() {
        return summaryToSearch;
    }

    public void setSummaryToSearch(String summaryToSearch) {
        this.summaryToSearch = summaryToSearch;
    }

    public String getRequiredExperienceToSearch() {
        return requiredExperienceToSearch;
    }

    public void setRequiredExperienceToSearch(String requiredExperienceToSearch) {
        this.requiredExperienceToSearch = requiredExperienceToSearch;
    }

    public String getRequiredSkillsToSearch() {
        return requiredSkillsToSearch;
    }

    public void setRequiredSkillsToSearch(String requiredSkillsToSearch) {
        this.requiredSkillsToSearch = requiredSkillsToSearch;
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }
}
