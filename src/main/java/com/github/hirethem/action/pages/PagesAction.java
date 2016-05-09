package com.github.hirethem.action.pages;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by egorshulga on 30-Apr-16.
 */
public class PagesAction extends ActionSupport {

    public String about() {
        return "about";
    }

    public String contact() {
        return "contact";
    }

    public String faq() {
        return "faq";
    }

}
