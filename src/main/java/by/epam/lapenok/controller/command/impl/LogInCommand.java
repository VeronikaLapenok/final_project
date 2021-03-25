package by.epam.lapenok.controller.command.impl;

import by.epam.lapenok.controller.command.Command;
import by.epam.lapenok.controller.command.PagePath;
import by.epam.lapenok.exception.ServiceException;
import by.epam.lapenok.model.entity.User;
import by.epam.lapenok.model.service.UserService;
import by.epam.lapenok.model.service.impl.UserServiceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class LogInCommand implements Command {
    private static Logger logger = LogManager.getLogger();

    private static final String PARAMETER_NAME_LOGIN = "login";
    private static final String PARAMETER_NAME_PASSWORD = "password";
    private UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(PARAMETER_NAME_LOGIN);
        String password = request.getParameter(PARAMETER_NAME_PASSWORD);
        try {
            userService.logIn(login, password);
            page = PagePath.MAIN;
        } catch (ServiceException e) {
            logger.error("Log in command error", e);
            page = PagePath.ERROR_404;
        }
        return page;
    }
}
