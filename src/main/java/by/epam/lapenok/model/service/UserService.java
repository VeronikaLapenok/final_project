package by.epam.lapenok.model.service;

import by.epam.lapenok.model.entity.User;
import by.epam.lapenok.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> logIn(String login, String password) throws ServiceException;
    List<User> showAllUsers() throws ServiceException;
    List<User> findUserBySurname(String surname) throws ServiceException;
}
