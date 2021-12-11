package com.labovichl.lab3.server.dao.paeser.description;

import com.labovichl.lab3.server.entity.StudentInfo;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface XMLStudentInfoParser {
    List<StudentInfo> takeAll(String path) throws IOException, SAXException, ParserConfigurationException;

    Optional<StudentInfo> takeByGradeBookNumber(String path, String gradeBookNumber) throws IOException, SAXException, ParserConfigurationException;

    List<StudentInfo> takeBySpeciality(String path,String  speciality) throws IOException, SAXException, ParserConfigurationException;

    void updateStudentInfo(String path,String gradeBookNumberToSearch,StudentInfo studentInfo) throws IOException, SAXException, ParserConfigurationException, TransformerException;

    void saveStudentInfo(String path,StudentInfo studentInfo) throws IOException, SAXException, ParserConfigurationException, TransformerException;

}
