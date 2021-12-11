package com.labovichl.lab3.server.service.impl;

import com.labovichl.lab3.server.dao.DaoFactory;
import com.labovichl.lab3.server.dao.description.StudentInfoDao;
import com.labovichl.lab3.server.entity.StudentInfo;
import com.labovichl.lab3.server.exeptions.DaoException;
import com.labovichl.lab3.server.exeptions.ServiceException;
import com.labovichl.lab3.server.service.description.StudentInfoService;
import com.labovichl.lab3.server.service.validator.Validator;
import com.labovichl.lab3.server.service.validator.ValidatorFactory;

import java.util.*;

public class StudentInfoServiceImpl implements StudentInfoService {

    @Override
    public List<StudentInfo> findAll() throws ServiceException {
        try {
            StudentInfoDao studentInfoDao = DaoFactory.getInstance().getStudentInfoDao();

            List<StudentInfo> result ;
            result = studentInfoDao.findAll();
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<StudentInfo> findByGradeBookNumber(String gradeBookNumber) throws ServiceException {
        try {
            StudentInfoDao studentInfoDao = DaoFactory.getInstance().getStudentInfoDao();
            Optional<StudentInfo> result;
            result = studentInfoDao.findByGradeBookNumber(gradeBookNumber);
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<StudentInfo> findBySpeciality(String speciality) throws ServiceException {
        try {
            StudentInfoDao studentInfoDao = DaoFactory.getInstance().getStudentInfoDao();
            List<StudentInfo> result ;
            result = studentInfoDao.findBySpeciality(speciality);
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


    @Override
    public boolean saveStudentInfo(String name, String surname, String patronymic,
                                   String stringBirthday, String sex, String gradeBookNumber, String speciality) throws ServiceException {
        if(name==null || surname==null || patronymic ==null ||
                stringBirthday ==null || sex ==null || gradeBookNumber ==null || speciality==null){
            return false;
        }
        Validator birthdayValidator= ValidatorFactory.getInstance().getBithdayValidator();
        Validator gradeBookValidator=ValidatorFactory.getInstance().getGradeBookValidator();

        if(!(birthdayValidator.isValid(stringBirthday) && gradeBookValidator.isValid(gradeBookNumber))){
            return false;
        }
        Date birthday=buildBirthday(stringBirthday);
        StudentInfo studentInfo=buildStudentInfo(name,surname,patronymic,birthday,sex,gradeBookNumber,speciality);
        StudentInfoDao studentInfoDao=DaoFactory.getInstance().getStudentInfoDao();
        try {
            studentInfoDao.saveStudentInfo(studentInfo);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateStudentInfoByGradeBookNumber(String gradeBookNumberToSearch, String name, String surname,
                                                      String patronymic, String stringBirthday, String sex, String gradeBookNumber,
                                                      String speciality) throws ServiceException {
        if(gradeBookNumberToSearch==null || name==null || surname==null || patronymic ==null ||
                stringBirthday ==null || sex ==null || gradeBookNumber ==null || speciality==null){
            return false;
        }
        Validator birthdayValidator= ValidatorFactory.getInstance().getBithdayValidator();
        Validator gradeBookValidator=ValidatorFactory.getInstance().getGradeBookValidator();

        if(!(birthdayValidator.isValid(stringBirthday) && gradeBookValidator.isValid(gradeBookNumber)
                && gradeBookValidator.isValid(gradeBookNumberToSearch))){
            return false;
        }
        Date birthday=buildBirthday(stringBirthday);
        StudentInfo studentInfo=buildStudentInfo(name,surname,patronymic,birthday,sex,gradeBookNumber,speciality);
        StudentInfoDao studentInfoDao=DaoFactory.getInstance().getStudentInfoDao();
        try {
            studentInfoDao.updateStudentInfoByGradeBookNumber(gradeBookNumberToSearch,studentInfo);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private Date buildBirthday(String birthday){
        String[] data=birthday.split("\\.");
        int year=Integer.parseInt(data[2]);
        int month=Integer.parseInt(data[1]);
        int day=Integer.parseInt(data[0]);
        Calendar calendar = new GregorianCalendar(year,month-1 , day);
        Date date = calendar.getTime();
        return date;
    }

    private StudentInfo buildStudentInfo(String name, String surname, String patronymic, Date birthday, String sex, String gradeBookNumber, String speciality){
        StudentInfo studentInfo=new StudentInfo();
        studentInfo.setName(name);
        studentInfo.setSurname(surname);
        studentInfo.setPatronymic(patronymic);
        studentInfo.setBirthday(birthday);
        studentInfo.setSex(sex);
        studentInfo.setGradeBookNumber(gradeBookNumber);
        studentInfo.setSpeciality(speciality);
        return studentInfo;
    }
}
