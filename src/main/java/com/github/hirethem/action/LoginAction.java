package com.github.hirethem.action;

import com.github.hirethem.model.service.LoginService;
import com.github.hirethem.model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * Created by egors.
 */
public class LoginAction extends ActionSupport {

    private String email;
    private String password;

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
            requiredStrings = {@RequiredStringValidator(message = "Email field must not be empty")},
            emails = {@EmailValidator(message = "Input email format is wrong")}
    )
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @RequiredStringValidator(message = "Field must not be empty")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
