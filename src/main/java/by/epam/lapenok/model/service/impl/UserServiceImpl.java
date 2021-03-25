package by.epam.lapenok.model.service.impl;

import by.epam.lapenok.exception.DaoException;
import by.epam.lapenok.exception.ServiceException;
import by.epam.lapenok.model.dao.UserDao;
import by.epam.lapenok.model.dao.impl.UserDaoImpl;
import by.epam.lapenok.model.entity.User;
import by.epam.lapenok.model.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import by.epam.lapenok.model.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserServiceImpl implements UserService {
    private static Logger logger = LogManager.getLogger();

    UserDao userDao = new UserDaoImpl();

    @Override
    public Optional<User> logIn(String login, String password) throws ServiceException {
//        try {
//            Optional<User> user = Optional.empty();
//            if (UserValidator.isUserLoginValid(login) && UserValidator.isUserPasswordValid(password)) {
//                //TODO
//            }
//        } catch () {
//
//        }
        return Optional.empty();
    }

    @Override
    public List<User> showAllUsers() throws ServiceException {
        List<User> users = new ArrayList<>();
        try {
            users = userDao.showAllUsers();
        } catch (DaoException e) {
            logger.error("Cannot search users", e);
        }
        return users;
    }

    @Override
    public List<User> findUserBySurname(String surname) throws ServiceException {
        try {
            List<User> users = new ArrayList<>();
            if (UserValidator.isUserSurnameValid(surname)) {
                users = userDao.findUserBySurname(surname);
            }
            return users;
        } catch (DaoException e) {
            logger.error("Cannot search user by name", e);
            throw new ServiceException(e);
        }
    }
}
