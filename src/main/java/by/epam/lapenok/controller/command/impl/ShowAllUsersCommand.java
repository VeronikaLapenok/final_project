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


public class ShowAllUsersCommand implements Command {
    private static Logger logger = LogManager.getLogger();

    private static final String ATTRIBUTE_USERS = "users";
    private UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        List<User> users;
        String page;
        try {
            users = userService.showAllUsers();
            request.setAttribute(ATTRIBUTE_USERS, users);
            page = PagePath.USERS;
        } catch (ServiceException e) {
            logger.error("Show all users command error", e);
            page = PagePath.ERROR_404;
        }
        return page;
    }
}
