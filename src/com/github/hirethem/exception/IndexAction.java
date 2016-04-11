package com.github.hirethem.exception;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by egors.
 */
@Result(location = "index.jsp")
@Action("")
public class IndexAction extends ActionSupport {
}
