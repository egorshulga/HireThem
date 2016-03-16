package com.github.hirethem.controller.command.impl;


import com.github.hirethem.controller.command.Command;
import com.github.hirethem.controller.command.exception.CommandException;
import com.github.hirethem.controller.name.JspPageName;
import com.github.hirethem.controller.name.RequestParameterName;
import com.github.hirethem.entity.User;
import com.github.hirethem.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ResourceBundle;

/**
 * Controls login user to site.
 * Handle "login" button.
 */
public class LoginCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);

    /**
     * Provides work with database users table.
     */
    private static final UserService userService = UserService.getInstance();


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String login = request.getParameter(RequestParameterName.LOGIN);
        String password = request.getParameter(RequestParameterName.PASSWORD);

        String result = JspPageName.LOGIN_JSP;

        try {
            User user = userService.login(login, password);
            if (user != null && user.getRole() != User.Role.BLOCKED) {
                result = JspPageName.HELLO_JSP;
                request.getSession().setAttribute(RequestParameterName.USER, user);
            } else {
                String path = RequestParameterName.I18N;
                String curLan = (String) request.getSession().getAttribute(RequestParameterName.LANGUAGE);
                if (curLan != null && !curLan.equals(RequestParameterName.EN))
                    path += RequestParameterName.UNDERLINE + curLan;
                ResourceBundle rb = ResourceBundle.getBundle(path);
                if (user != null && user.getRole() == User.Role.BLOCKED) { // if user is blocked
                    request.setAttribute(RequestParameterName.MESSAGE, rb.getString("login.blocked"));
                } else {
                    request.setAttribute(RequestParameterName.MESSAGE, rb.getString("login.wrong"));
                }

            }
        } catch (Exception e) {
            LOGGER.error("Can't execute LoginCommand");
            throw new CommandException("Cant't execute LoginCommand");
        }
        return result;
    }
}
