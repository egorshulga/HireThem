package com.github.hirethem.action;

import com.github.hirethem.model.dao.LoginDao;
import com.github.hirethem.model.dao.exception.DaoException;
import com.github.hirethem.model.service.PasswordEncryptionService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by egors.
 */
public class LoginAction extends ActionSupport implements SessionAware {

    private SessionMap<String, Object> sessionMap;
    private String email;
    private String password;

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

    public String execute() {
        sessionMap.put("email", email);
        return SUCCESS;
    }

    public void validate() {
        LoginDao loginDao = new LoginDao();

        byte[] salt;
        try {
            salt = loginDao.getSalt(email);
        } catch (DaoException e) {
            addFieldError("email", e.getMessage());
            return;
        }

        PasswordEncryptionService passwordEncryptionService = new PasswordEncryptionService();
        byte[] encryptedInputPassword;
        try {
            encryptedInputPassword = passwordEncryptionService.getEncryptedPassword(password, salt);
        } catch (Exception ignored) {
            addActionError("Unable to perform password encryption");
            return;
        }

        byte[] encryptedRealPassword;
        try {
            encryptedRealPassword = loginDao.getEncryptedPassword(email);
        } catch (DaoException e) {
            addFieldError("email", e.getMessage());
            return;
        }

        if (!Arrays.equals(encryptedInputPassword, encryptedRealPassword)) {
            addFieldError("email", "Wrong password");
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
