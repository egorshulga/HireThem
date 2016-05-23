package com.github.hirethem.action.vacancies;

import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.CurrentUserService;
import com.github.hirethem.model.service.VacancyService;
import com.github.hirethem.model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by egorshulga on 12-May-16.
 */
public class DeleteVacancyAction extends ActionSupport {

    protected int vacancyId;

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

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }


}
