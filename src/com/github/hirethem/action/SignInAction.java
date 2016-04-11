package com.github.hirethem.action;

import com.github.hirethem.model.dao.SignInDao;
import com.github.hirethem.model.dao.exception.DaoException;
import com.github.hirethem.model.entity.UserType;
import com.github.hirethem.model.service.PasswordEncryptionService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by egors.
 */
public class SignInAction extends ActionSupport implements SessionAware {
    private SessionMap<String, Object> sessionMap;

    private SignInDao signInDao = new SignInDao();

    private String email;
    private String password;
    private String name;
    private String surname;
    private String userType;

    private List<String> userTypes = new ArrayList<>();

    public SignInAction() {
        userTypes.add("employee");
        userTypes.add("employer");
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

    public String execute() {
        PasswordEncryptionService passwordEncryptionService = new PasswordEncryptionService();
        byte[] salt;
        try {
            salt = passwordEncryptionService.generateSalt();
        } catch (NoSuchAlgorithmException e) {
            return INPUT;
        }

        byte[] encryptedPassword;
        try {
            encryptedPassword = passwordEncryptionService.getEncryptedPassword(password, salt);
        } catch (Exception e) {
            return INPUT;
        }

        signInDao.createNewUser(email, encryptedPassword, salt, name, surname, UserType.valueOf(userType));

        sessionMap.put("email", email);
        return SUCCESS;
    }

    public void validate() {
        try {
            if (signInDao.getUser(email) != null) {
                addFieldError("email", "User with this email is already registered");
            }
        } catch (DaoException e) {
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

    @RequiredStringValidator(message = "Field must not be empty")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @RequiredStringValidator(message = "Field must not be empty")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @RequiredFieldValidator(message = "User type must be selected")
    public List<String> getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(List<String> userTypes) {
        this.userTypes = userTypes;
    }
}
