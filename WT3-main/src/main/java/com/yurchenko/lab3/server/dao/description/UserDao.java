package com.labovichl.lab3.server.dao.description;

import com.labovichl.lab3.server.entity.User;
import com.labovichl.lab3.server.exeptions.DaoException;

import java.util.Optional;

public interface UserDao {

    Optional<User> findByLoginAndPassword(String login, String password) throws DaoException;



}
