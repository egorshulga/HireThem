package com.github.hirethem.action.vacancies;

import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.entity.Vacancy;
import com.github.hirethem.model.service.CurrentUserService;
import com.github.hirethem.model.service.VacancyService;
import com.github.hirethem.model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by egorshulga on 06-May-16.
 */
public class ManageVacanciesAction extends ActionSupport {

    private User user;
    private List<Vacancy> vacancies;

    public String execute() {
        try {
            user = new CurrentUserService().getCurrentUserEntity();
            vacancies = new VacancyService().getVacancies(user.getId());
        } catch (ServiceException ignored) {
        }
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }
}
