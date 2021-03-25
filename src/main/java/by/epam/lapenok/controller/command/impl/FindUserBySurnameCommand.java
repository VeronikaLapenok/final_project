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
import java.util.List;

public class FindUserBySurnameCommand implements Command {
    private static Logger logger = LogManager.getLogger();

    private static final String PARAMETER_USER_SURNAME = "user_surname";
    private static final String ATTRIBUTE_USERS = "users";
    private UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        List<User> users;
        String page;
        String surname = request.getParameter(PARAMETER_USER_SURNAME);
        try {
            users = userService.findUserBySurname(surname);
            request.setAttribute(ATTRIBUTE_USERS, users);
            page = PagePath.USERS;
        } catch (ServiceException e) {
            logger.error("Find user by surname command error", e);
            page = PagePath.ERROR_404;
        }
        return page;
    }
}
