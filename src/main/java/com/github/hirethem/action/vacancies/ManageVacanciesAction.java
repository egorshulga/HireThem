package com.github.hirethem.action.vacancies;

import com.github.hirethem.action.interceptor.AuthorizeAs;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.entity.Vacancy;
import com.github.hirethem.model.service.CurrentUserService;
import com.github.hirethem.model.service.SessionService;
import com.github.hirethem.model.service.VacancyService;
import com.github.hirethem.model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by egorshulga on 06-May-16.
 */
@AuthorizeAs(userType = "EMPLOYER")
public class ManageVacanciesAction extends ActionSupport {

    protected User user;
    protected List<Vacancy> vacancies;
    protected int chosenVacancyId;

    public String input() {
        try {
            user = new CurrentUserService().getCurrentUserEntity();
            vacancies = new VacancyService().getVacancies(user.getId());
        } catch (ServiceException ignored) {
        }
        return SUCCESS;
    }

    public String execute() {
        new SessionService().put("chosenVacancyId", chosenVacancyId);
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

    public int getChosenVacancyId() {
        return chosenVacancyId;
    }

    public void setChosenVacancyId(int chosenVacancyId) {
        this.chosenVacancyId = chosenVacancyId;
    }

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }


}
