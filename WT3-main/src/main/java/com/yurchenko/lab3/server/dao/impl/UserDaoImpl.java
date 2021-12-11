package com.labovichl.lab3.server.dao.impl;

import com.labovichl.lab3.server.dao.description.UserDao;
import com.labovichl.lab3.server.dao.paeser.ParserFactory;
import com.labovichl.lab3.server.dao.paeser.impl.XMLUserParserImpl;
import com.labovichl.lab3.server.entity.User;
import com.labovichl.lab3.server.exeptions.DaoException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) throws DaoException {
        try {
            return ParserFactory.getInstance().getUserParser().takeUser("src\\main\\resources\\Users.xml",login,password);
        } catch (IOException | SAXException | ParserConfigurationException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

}
