package com.labovichl.lab3.server.service;

import com.labovichl.lab3.server.dao.DaoFactory;
import com.labovichl.lab3.server.service.description.StudentInfoService;
import com.labovichl.lab3.server.service.description.UserService;
import com.labovichl.lab3.server.service.impl.StudentInfoServiceImpl;
import com.labovichl.lab3.server.service.impl.UserServiceImpl;

public class ServiceFactory {

    private final UserService userService=new UserServiceImpl();
    private final StudentInfoService studentInfoService=new StudentInfoServiceImpl();

    public UserService getUserService() {
        return userService;
    }

    public StudentInfoService getStudentInfoService() {
        return studentInfoService;
    }

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static final ServiceFactory INSTANCE = new ServiceFactory();
    }
}
