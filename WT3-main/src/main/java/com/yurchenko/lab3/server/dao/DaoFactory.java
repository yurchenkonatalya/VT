package com.labovichl.lab3.server.dao;

import com.labovichl.lab3.server.dao.description.StudentInfoDao;
import com.labovichl.lab3.server.dao.description.UserDao;
import com.labovichl.lab3.server.dao.impl.StudentInfoDaoImpl;
import com.labovichl.lab3.server.dao.impl.UserDaoImpl;

public class DaoFactory {
    private final UserDao userDao = new UserDaoImpl();
    private final StudentInfoDao studentInfoDao=new StudentInfoDaoImpl();

    public UserDao getUserDao() {
        return userDao;
    }

    public StudentInfoDao getStudentInfoDao() {
        return studentInfoDao;
    }

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static final DaoFactory INSTANCE = new DaoFactory();
    }
}
