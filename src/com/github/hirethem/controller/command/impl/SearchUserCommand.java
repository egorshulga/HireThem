package com.github.hirethem.controller.command.impl;


import com.github.hirethem.controller.command.Command;
import com.github.hirethem.controller.command.exception.CommandException;
import com.github.hirethem.controller.name.JspPageName;
import com.github.hirethem.entity.User;
import com.github.hirethem.service.UserService;
import com.github.hirethem.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.github.hirethem.util.SessionUtil.sessionExpired;

/**
 *
 */
public class SearchUserCommand implements Command {

    private static final UserService userService = UserService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result = JspPageName.USERS_JSP;

        if (sessionExpired(request)) {
            result = JspPageName.LOGIN_JSP;
            return result;
        }

        String login = request.getParameter("login");
        try {
            User user = userService.get(login);
            if (user != null) {
                request.setAttribute("founded_user", user);
            } else {
                request.setAttribute("message", "not found");
            }
        } catch (ServiceException e) {
            throw new CommandException("Cant't execute SearchUserCommand");
        }

        return result;
    }
}
