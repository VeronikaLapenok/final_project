package by.epam.lapenok.model.dao;

import by.epam.lapenok.exception.DaoException;
import by.epam.lapenok.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> logIn(String login, String password) throws DaoException;
    List<User> showAllUsers() throws DaoException;
    List<User> findUserBySurname(String surname) throws DaoException;
}
