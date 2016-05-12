package com.github.hirethem.action.admin.vacancies;

import com.github.hirethem.action.interceptor.AuthorizeAs;
import com.github.hirethem.action.vacancies.ManageVacanciesAction;
import com.github.hirethem.model.service.VacancyService;

/**
 * Created by egorshulga on 12-May-16.
 */
@AuthorizeAs(admin = true)
public class ManageVacanciesAdminPanelAction extends ManageVacanciesAction {

    public String execute() {
        vacancies = new VacancyService().getAllVacancies();
        return SUCCESS;
    }
}
