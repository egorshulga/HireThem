package com.github.hirethem.controller.command.impl;


import com.github.hirethem.controller.command.Command;
import com.github.hirethem.controller.command.exception.CommandException;
import com.github.hirethem.controller.name.JspPageName;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Control unhandled situations.
 */
public class UnknownCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(UnknownCommand.class);

    public UnknownCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        return JspPageName.ERROR_JSP;
    }
}
