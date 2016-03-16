package com.github.hirethem.controller.command.impl;


import com.github.hirethem.controller.command.Command;
import com.github.hirethem.controller.command.exception.CommandException;
import com.github.hirethem.controller.name.JspPageName;
import com.github.hirethem.controller.name.RequestParameterName;
import com.github.hirethem.entity.User;
import com.github.hirethem.service.UserService;
import com.github.hirethem.service.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ResourceBundle;

/**
 * Control users registration to site.
 * Handle "register" button.
 */
public class RegisterCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(RegisterCommand.class);

    private static UserService userService = UserService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String name = request.getParameter(RequestParameterName.NAME);
        String surname = request.getParameter(RequestParameterName.SURNAME);
        String login = request.getParameter(RequestParameterName.LOGIN);
        String password = request.getParameter(RequestParameterName.PASSWORD);
        String email = request.getParameter(RequestParameterName.EMAIL);
        String payCard = request.getParameter(RequestParameterName.PAY_CARD_ID);

        String result = JspPageName.REGISTER_JSP;
        try {
            if (userService.get(login) == null) {
                User user = userService.create(name, surname, email, payCard, login, password);
                result = JspPageName.LOGIN_JSP;//зарегался - теперь залогинься
            } else {
                String path = RequestParameterName.I18N;
                String currentLanguage = (String) request.getSession().getAttribute(RequestParameterName.LANGUAGE);
                if (currentLanguage != null && !currentLanguage.equals(RequestParameterName.EN)) {
                    path += RequestParameterName.UNDERLINE + currentLanguage;
                }
                ResourceBundle rb = ResourceBundle.getBundle(path);
                request.setAttribute(RequestParameterName.REQUIRED_MESSAGE, rb.getString("register.wrong"));
            }
        } catch (ServiceException e) {
            LOGGER.error("Can't do UserService in RegisterCommand ");
            throw new CommandException("Registration failed");
        }

        return result;
    }
}
