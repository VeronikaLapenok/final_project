package by.epam.lapenok.controller.command;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import by.epam.lapenok.controller.command.impl.EmptyCommand;
import org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;

public class CommandProvider {
    private static Logger logger = LogManager.getLogger();

    private static final String COMMAND = "command";

    public static Command defineCommand(HttpServletRequest request) {
        Command currentCommand = null;
        String action = request.getParameter(COMMAND);
        if (action == null || action.isEmpty()) {
            return new EmptyCommand();
        }

        try {
            CommandName currentName = CommandName.valueOf(action.toUpperCase());
            currentCommand = currentName.getCommand();
        } catch (IllegalArgumentException e) {
            logger.error("Wrong command");
            currentCommand = new EmptyCommand();
        }
        return currentCommand;
    }
}
