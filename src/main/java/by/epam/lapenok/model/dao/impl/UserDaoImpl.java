package by.epam.lapenok.model.dao.impl;

import by.epam.lapenok.exception.DaoException;
import by.epam.lapenok.model.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import by.epam.lapenok.model.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDaoImpl implements UserDao {
    private static Logger logger = LogManager.getLogger();

    private static final String SQL_FIND_USER_BY_NAME = "SELECT id, name, surname, phone FROM users WHERE name like ?";

    @Override
    public List<User> findUserByName(String name) throws DaoException {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = Con
        }
    }
}
