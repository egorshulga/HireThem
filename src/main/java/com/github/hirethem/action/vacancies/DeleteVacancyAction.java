package com.github.hirethem.action.vacancies;

import com.github.hirethem.model.service.VacancyService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by egorshulga on 12-May-16.
 */
public class DeleteVacancyAction extends ActionSupport {

    private int vacancyId;

    public String execute() {
        new VacancyService().deleteVacancy(vacancyId);
        return SUCCESS;
    }

    public int getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
    }
}
