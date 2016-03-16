package com.github.hirethem.controller.command;


import com.github.hirethem.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Command pattern realization for all commands.
 */
public final class CommandHelper {
    private static final CommandHelper instance = new CommandHelper();

    private final Map<CommandName, Command> commandMap = new HashMap<>();

    public CommandHelper() {
        commandMap.put(CommandName.UNKNOWN_COMMAND, new UnknownCommand());
        commandMap.put(CommandName.LOGIN_COMMAND, new LoginCommand());
        commandMap.put(CommandName.LOGOUT_COMMAND, new LogoutCommand());
        commandMap.put(CommandName.REGISTER_COMMAND, new RegisterCommand());
        commandMap.put(CommandName.SEARCH_USER_COMMAND, new SearchUserCommand());
    }

    public Command getCommand(String commandName) {
        CommandName name = CommandName.valueOf(commandName.toUpperCase());
        Command command;
        if (name != null) {
            command = commandMap.get(name);
        } else {
            command = commandMap.get(CommandName.UNKNOWN_COMMAND);
        }
        return command;
    }

    public static CommandHelper getInstance() {
        return instance;
    }

}
