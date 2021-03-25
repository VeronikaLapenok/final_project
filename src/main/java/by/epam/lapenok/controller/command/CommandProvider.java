package by.epam.lapenok.controller.command;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;

public class CommandProvider {
    private static Logger logger = LogManager.getLogger();

    public static Command defineCommand(HttpServletRequest request) {
        Command currentCommand = null;
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return new EmptyCommand();
        }

        try {
            CommandName currentName = CommandName.valueOf(action.toUpperCase());
            currentCommand = currentName.getCommand();
        } catch (IllegalArgumentException e) {
            logger.error("Wrong action");
            currentCommand = new EmptyCommand();
        }
        return currentCommand;
    }
}
