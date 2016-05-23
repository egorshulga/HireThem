package com.github.hirethem.action.admin.vacancies;

import com.github.hirethem.action.interceptor.AuthorizeAs;
import com.github.hirethem.action.vacancies.ModifyVacancyAction;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.CurrentUserService;
import com.github.hirethem.model.service.exception.ServiceException;

/**
 * Created by egorshulga on 12-May-16.
 */
@AuthorizeAs(admin = true)
public class ModifyVacancyAdminPanelAction extends ModifyVacancyAction {

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }


}
