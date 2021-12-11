package com.labovichl.lab3.server.dao.impl;

import com.labovichl.lab3.server.dao.description.StudentInfoDao;
import com.labovichl.lab3.server.dao.paeser.ParserFactory;
import com.labovichl.lab3.server.dao.paeser.impl.XMLStudentInfoParserImpl;
import com.labovichl.lab3.server.entity.StudentInfo;
import com.labovichl.lab3.server.exeptions.DaoException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class StudentInfoDaoImpl implements StudentInfoDao {
    private  static final String FILE_PATH="src\\main\\resources\\StudentsInfo.xml";

    @Override
    public List<StudentInfo> findAll() throws DaoException {

        try {
            return  ParserFactory.getInstance().getStudentInfoParser().takeAll(FILE_PATH);
        } catch (IOException | SAXException | ParserConfigurationException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<StudentInfo> findByGradeBookNumber(String gradeBookNumber) throws DaoException {
        try {
            return ParserFactory.getInstance().getStudentInfoParser().takeByGradeBookNumber(FILE_PATH,gradeBookNumber);
        } catch (IOException | SAXException | ParserConfigurationException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<StudentInfo> findBySpeciality(String speciality) throws DaoException {
        try {
            return ParserFactory.getInstance().getStudentInfoParser().takeBySpeciality(FILE_PATH,speciality);
        } catch (IOException | SAXException | ParserConfigurationException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public void updateStudentInfoByGradeBookNumber(String gradeBookNumberToSearch, StudentInfo studentInfo) throws DaoException {
        try {
            ParserFactory.getInstance().getStudentInfoParser().updateStudentInfo(FILE_PATH,gradeBookNumberToSearch,studentInfo);
        } catch (IOException | SAXException | ParserConfigurationException | TransformerException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }


    @Override
    public void saveStudentInfo(StudentInfo studentInfo) throws DaoException {
        try {
            ParserFactory.getInstance().getStudentInfoParser().saveStudentInfo(FILE_PATH,studentInfo);
        } catch (IOException | SAXException | ParserConfigurationException | TransformerException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
}
