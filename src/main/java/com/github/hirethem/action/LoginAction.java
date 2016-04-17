package com.github.hirethem.action;

import com.github.hirethem.model.service.LoginService;
import com.github.hirethem.model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

import static com.github.hirethem.Const.*;

/**
 * Created by egors.
 */
public class LoginAction extends ActionSupport {

    private String email;
    private String password;

    public String input() {
        return INPUT;
    }

    public String execute() {
        new LoginService().saveUserAuthetication(email);
        return SUCCESS;
    }

    public void validate() {
        try {
            new LoginService().tryAuthenticateUser(email, password);
        } catch (ServiceException e) {
            addFieldError("email", e.getMessage());
        }
    }

    @Validations(
            requiredStrings = {@RequiredStringValidator(message = EMPTY_FIELD)},
            emails = {@EmailValidator(message = WRONG_EMAIL_FORMAT)}
    )
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @RequiredStringValidator(message = EMPTY_FIELD)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
