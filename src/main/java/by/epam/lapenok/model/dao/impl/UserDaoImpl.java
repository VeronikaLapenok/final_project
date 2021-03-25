package by.epam.lapenok.model.dao.impl;

import by.epam.lapenok.exception.DaoException;
import by.epam.lapenok.model.dao.ColumnName;
import by.epam.lapenok.model.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import by.epam.lapenok.model.entity.User;
import by.epam.lapenok.model.pool.ConnectionCreator;
import by.epam.lapenok.model.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDaoImpl implements UserDao {
    private static Logger logger = LogManager.getLogger();

    private static final String SQL_SHOW_ALL_USERS = "SELECT user_id, name, surname FROM users";
    private static final String SQL_FIND_USER_BY_SURNAME = "SELECT user_id, name, surname FROM users WHERE surname like ?";

    @Override
    public Optional<User> logIn(String login, String password) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<User> showAllUsers() throws DaoException {
        List<User> users = new ArrayList<>();

        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SHOW_ALL_USERS);
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt(ColumnName.USER_ID));
                user.setName(resultSet.getString(ColumnName.NAME));
                user.setSurname(resultSet.getString(ColumnName.SURNAME));
                users.add(user);
            }
        } catch (SQLException e) {
            logger.error("Wrong database access", e);
            throw  new DaoException();
        }
        return users;
    }

    @Override
    public List<User> findUserBySurname(String surname) throws DaoException {
        List<User> users = new ArrayList<>();

        try{
            Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_USER_BY_SURNAME);
            statement.setString(1, surname);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt(ColumnName.USER_ID));
                user.setName(resultSet.getString(ColumnName.NAME));
                user.setSurname(resultSet.getString(ColumnName.SURNAME));
                users.add(user);
            }
        } catch (SQLException e) {
            logger.error("Wrong database access", e);
            throw  new DaoException();
        }
        return  users;
    }
}
