package com.github.hirethem.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by egors.
 */
public class HomeAction extends ActionSupport {

    public static final String MESSAGE = "hello.message";

    public String execute() {
        return SUCCESS;
    }

    public String getMessage() {
        return getText(MESSAGE);    //retrieve from resources
    }

}
