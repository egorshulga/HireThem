package com.github.hirethem.action.home;

import com.github.hirethem.model.service.VacancyService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by egors.
 */
public class IndexAction extends ActionSupport {

    private int vacanciesCount = 0;

    public String execute() {
        vacanciesCount = new VacancyService().getAllVacancies().size();
        return SUCCESS;
    }

    public int getVacanciesCount() {
        return vacanciesCount;
    }

    public void setVacanciesCount(int vacanciesCount) {
        this.vacanciesCount = vacanciesCount;
    }
}
