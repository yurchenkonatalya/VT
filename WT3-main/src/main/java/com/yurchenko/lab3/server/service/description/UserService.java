package com.labovichl.lab3.server.service.description;

import com.labovichl.lab3.server.entity.User;
import com.labovichl.lab3.server.exeptions.ServiceException;

import java.util.Optional;

public interface UserService {

    Optional<User> login(String login, String password) throws ServiceException;


}
