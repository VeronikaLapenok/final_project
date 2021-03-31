package by.epam.lapenok.model.service;

import by.epam.lapenok.model.entity.User;
import by.epam.lapenok.exception.ServiceException;

import java.util.List;

public interface UserService {
    List<User> findUserByName(String name) throws ServiceException;
}
