package com.github.hirethem.controller.command.impl;


import com.github.hirethem.controller.command.Command;
import com.github.hirethem.controller.command.exception.CommandException;
import com.github.hirethem.controller.name.JspPageName;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Control user logout from site.
 * Handle "logout" button.
 */
public class LogoutCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(LogoutCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        HttpSession currentSession = request.getSession(false);
        if (currentSession != null)
            currentSession.invalidate();
        LOGGER.info("LogoutCommand executed");
        return JspPageName.INDEX_JSP;
    }
}
