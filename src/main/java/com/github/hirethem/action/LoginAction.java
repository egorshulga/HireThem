package com.github.hirethem.action;

import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.LoginService;
import com.github.hirethem.model.service.UserService;
import com.github.hirethem.model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

import java.util.List;

import static com.github.hirethem.action.Message.EMPTY_FIELD;
import static com.github.hirethem.action.Message.WRONG_EMAIL_FORMAT;

/**
 * Created by egors.
 */
public class LoginAction extends ActionSupport {

    private String email;
    private String password;
    private User.UserType userType;

    public String input() {
        if (new LoginService().isUserAuthenticated()) {
            return NONE;
        } else {
            return INPUT;
        }
    }

    public String execute() {
        new LoginService().saveUserAuthentication(email, userType);
        return SUCCESS;
    }

    public void validate() {
        try {
            new LoginService().tryAuthenticateUser(email, password, userType);
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

    @RequiredFieldValidator(message = EMPTY_FIELD)
    public User.UserType getUserType() {
        return userType;
    }

    public void setUserType(User.UserType userType) {
        this.userType = userType;
    }

    public List<User.UserType> getUserTypes() {
        return UserService.getUserTypes();
    }

    public User.UserType getDefaultUserType() {
        return User.UserType.EMPLOYEE;
    }

}
