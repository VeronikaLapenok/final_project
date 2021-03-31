package by.epam.lapenok.model.dao;

import by.epam.lapenok.exception.DaoException;
import by.epam.lapenok.model.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findUserByName(String name) throws DaoException;
}
