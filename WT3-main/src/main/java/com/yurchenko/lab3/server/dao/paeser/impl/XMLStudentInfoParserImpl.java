package com.labovichl.lab3.server.dao.paeser.impl;

import com.labovichl.lab3.server.dao.paeser.description.XMLStudentInfoParser;
import com.labovichl.lab3.server.entity.StudentInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class XMLStudentInfoParserImpl implements XMLStudentInfoParser {

    @Override
    public List<StudentInfo> takeAll(String path) throws IOException, SAXException, ParserConfigurationException {
        Document document=parse(path);
        NodeList nodeList = document.getElementsByTagName("student-info");
        List<StudentInfo> result=new ArrayList<>(nodeList.getLength());
        for (int i = 0; i < nodeList.getLength(); i++) {
          result.add(takeStudentInfo(nodeList.item(i)));
        }
        return result;
    }
    @Override
    public Optional<StudentInfo> takeByGradeBookNumber(String path,String gradeBookNumber) throws IOException, SAXException, ParserConfigurationException {
        Document document=parse(path);
        NodeList nodeList = document.getElementsByTagName("student-info");
        Optional<StudentInfo> result=Optional.empty();
        for (int i = 0; i < nodeList.getLength(); i++) {
            StudentInfo studentInfo=takeStudentInfo(nodeList.item(i));
            if(gradeBookNumber.equals(studentInfo.getGradeBookNumber())){
                result=Optional.of(studentInfo);
                break;
            }

        }
        return result;
    }
    @Override
    public List<StudentInfo> takeBySpeciality(String path,String  speciality) throws IOException, SAXException, ParserConfigurationException {
        Document document=parse(path);
        NodeList nodeList = document.getElementsByTagName("student-info");
        List<StudentInfo> result=new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            StudentInfo studentInfo=takeStudentInfo(nodeList.item(i));
            if(speciality.equals(studentInfo.getSpeciality())){
                result.add(studentInfo);
            }

        }
        return result;
    }
    @Override
    public void updateStudentInfo(String path,String gradeBookNumberToSearch,StudentInfo studentInfo) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        Document document=parse(path);
        updateStudentInfo(document,gradeBookNumberToSearch,studentInfo);
        refreshFile(document,path);

    }
    @Override
    public void saveStudentInfo(String path,StudentInfo studentInfo) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        Document document=parse(path);
        addStudentInfo(document,studentInfo);
        refreshFile(document,path);

    }






    private Document parse(String path) throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File(path);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        return document;
    }

    private  StudentInfo takeStudentInfo(Node node) {
        StudentInfo studentInfo=new StudentInfo();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            studentInfo.setSurname(getTagValue("surname",element));
            studentInfo.setName(getTagValue("name",element));
            studentInfo.setPatronymic(getTagValue("patronymic",element));
            studentInfo.setBirthday(buildBirthday(getTagValue("birthday",element)));
            studentInfo.setSex(getTagValue("sex",element));
            studentInfo.setGradeBookNumber(getTagValue("gradebook-number",element));
            studentInfo.setSpeciality(getTagValue("speciality",element));


        }

        return studentInfo;
    }

    private  String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
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

    private void refreshFile(Document document,String filePath) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(filePath));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
    }

    private void updateStudentInfo(Document doc, String gradeBookNumberToSearch, StudentInfo studentInfo) {
        NodeList studentsInfoList = doc.getElementsByTagName("student-info");
        Element element = null;

        for(int i=0; i<studentsInfoList.getLength();i++){
            StudentInfo currentStudentInfo=takeStudentInfo(studentsInfoList.item(i));
            if(currentStudentInfo.getGradeBookNumber().equals(gradeBookNumberToSearch)){
                element = (Element) studentsInfoList.item(i);


                Node surname = element.getElementsByTagName("surname").item(0).getFirstChild();
                surname.setNodeValue(studentInfo.getSurname());

                Node name = element.getElementsByTagName("name").item(0).getFirstChild();
                name.setNodeValue(studentInfo.getName());

                Node patronymic = element.getElementsByTagName("patronymic").item(0).getFirstChild();
                patronymic.setNodeValue(studentInfo.getPatronymic());

                SimpleDateFormat formatForDate = new SimpleDateFormat("dd.MM.yyyy");
                Node birthday = element.getElementsByTagName("birthday").item(0).getFirstChild();
                birthday.setNodeValue(formatForDate.format(studentInfo.getBirthday()));

                Node sex = element.getElementsByTagName("sex").item(0).getFirstChild();
                sex.setNodeValue(studentInfo.getSex());

                Node gradeBookNumber = element.getElementsByTagName("gradebook-number").item(0).getFirstChild();
                gradeBookNumber.setNodeValue(studentInfo.getGradeBookNumber());

                Node speciality = element.getElementsByTagName("speciality").item(0).getFirstChild();
                speciality.setNodeValue(studentInfo.getSpeciality());

                break;
            }

        }

    }

    private static void addStudentInfo(Document doc, StudentInfo studentInfo) {
        Element root = (Element) doc.getElementsByTagName("students-info").item(0);

        Element cratedStudentInfo=doc.createElement("student-info");
        root.appendChild(cratedStudentInfo);

        Element element=doc.createElement("surname");
        element.appendChild(doc.createTextNode(studentInfo.getSurname()));
        cratedStudentInfo.appendChild(element);

        element=doc.createElement("name");
        element.appendChild(doc.createTextNode(studentInfo.getName()));
        cratedStudentInfo.appendChild(element);

        element=doc.createElement("patronymic");
        element.appendChild(doc.createTextNode(studentInfo.getPatronymic()));
        cratedStudentInfo.appendChild(element);

        SimpleDateFormat formatForDate = new SimpleDateFormat("dd.MM.yyyy");
        element=doc.createElement("birthday");
        element.appendChild(doc.createTextNode(formatForDate.format(studentInfo.getBirthday())));
        cratedStudentInfo.appendChild(element);

        element=doc.createElement("sex");
        element.appendChild(doc.createTextNode(studentInfo.getSex()));
        cratedStudentInfo.appendChild(element);

        element=doc.createElement("gradebook-number");
        element.appendChild(doc.createTextNode(studentInfo.getGradeBookNumber()));
        cratedStudentInfo.appendChild(element);

        element=doc.createElement("speciality");
        element.appendChild(doc.createTextNode(studentInfo.getSpeciality()));
        cratedStudentInfo.appendChild(element);

    }
}
