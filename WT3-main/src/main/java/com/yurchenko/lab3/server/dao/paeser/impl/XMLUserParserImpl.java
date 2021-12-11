package com.labovichl.lab3.server.dao.paeser.impl;

import com.labovichl.lab3.server.dao.paeser.description.XMLUserParser;
import com.labovichl.lab3.server.entity.Role;
import com.labovichl.lab3.server.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class XMLUserParserImpl implements XMLUserParser {
    @Override
    public Optional<User> takeUser(String path, String login, String password) throws IOException, SAXException, ParserConfigurationException {
        File xmlFile = new File(path);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Optional<User> result=Optional.empty();

            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("user");
            for (int i = 0; i < nodeList.getLength(); i++) {
                User user=takeUser(nodeList.item(i));
                if(user.getLogin().equals(login) && user.getPassword().equals(password)){
                    result=Optional.of(user);
                    break;
                }
            }


        return result;

    }

    private static User takeUser(Node node) {
        User user=new User();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            user.setLogin(getTagValue("login", element));
            user.setPassword(getTagValue("password", element));
            user.setRole(Role.valueOf(getTagValue("role", element)));

        }

        return user;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

}
