package com.github.hirethem.controller.command;


import com.github.hirethem.controller.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface for business logic classes.
 */
public interface Command {
    String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException;
}
