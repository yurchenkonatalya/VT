package com.labovichl.lab3.server.service.impl;

import com.labovichl.lab3.server.dao.DaoFactory;
import com.labovichl.lab3.server.dao.description.UserDao;
import com.labovichl.lab3.server.entity.User;
import com.labovichl.lab3.server.exeptions.DaoException;
import com.labovichl.lab3.server.exeptions.ServiceException;
import com.labovichl.lab3.server.service.description.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public Optional<User> login(String login, String password) throws ServiceException {
        if (login == null || password == null) {
            return Optional.empty();
        }
        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            return userDao.findByLoginAndPassword(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
