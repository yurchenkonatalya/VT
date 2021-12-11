package by.tc.task01.dao.impl.parser;

import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.control.ApplianceController;
import by.tc.task01.service.control.factory.ControllerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * класс-реализация парсера XML
 */
public class XMLParserImpl implements XMLParser {
    private  ArrayList<Appliance> appliances = new ArrayList<>();
    /**
     * метод парсинга файла
     * @param path путь к файлу
     * @throws ParserConfigurationException ошибка конфигурации парсера
     * @throws SAXException ошибка парсера типа SAX
     * @throws IOException ошибка ввода-вывода
     */
    @Override
    public void parse(String path) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();


        XMLHandler handler = new XMLHandler();
        parser.parse(new File(path), handler);
    }
    /**
     * метод получения приборов по заданным критериям
     * @param criteria критерии прибора
     * @return список приборов по заданным критериям
     */
    @Override
    public List<Appliance> take(Criteria criteria) {
        List<Appliance> listToReturn=new ArrayList<>();

        Set<String> keys=criteria.getKeysSet();

        ControllerFactory controllerFactory=ControllerFactory.getInstance();

        if(criteria.getGroupSearchName().isEmpty()){
           listToReturn.addAll(appliances);
           return listToReturn;
        }

        for (int i = 0; i <appliances.size(); i++) {

             ApplianceController applianceController=controllerFactory.takeApplianceConrtoller(appliances.get(i));

             if(criteria.getGroupSearchName().equals(appliances.get(i).getClass().getSimpleName())){

                 Iterator<String> iterator=keys.iterator();
                 boolean isValid=true;
                 while (iterator.hasNext()){
                     String key=iterator.next();
                     if(!(applianceController.isContainsValue(key,criteria.get(key)))){
                         isValid=false;
                         break;
                     }
                 }
                 if(isValid){
                     listToReturn.add(appliances.get(i));
                 }
             }

        }
        return listToReturn;
    }

    /**
     * класс-компонент для класса-парсера XML
     */
    private  class XMLHandler extends DefaultHandler {
        /**
         * метод парсинга
         * @param uri uri пространства имён
         * @param localName локальное имя (без префикса)
         * @param qName имя с префиксом
         * @param attributes атрибуты прикреплённые к элементу
         * @throws SAXException любая ошибка SAX
         */
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("oven")) {
                double price = Double.parseDouble(attributes.getValue("price"));
                double powerConsumption = Double.parseDouble(attributes.getValue("power-consumption"));
                double weight = Double.parseDouble(attributes.getValue("weight"));
                double capacity = Double.parseDouble(attributes.getValue("capacity"));
                double depth = Double.parseDouble(attributes.getValue("depth"));
                double height = Double.parseDouble(attributes.getValue("height"));
                double width = Double.parseDouble(attributes.getValue("width"));

                appliances.add(new Oven(price,powerConsumption, weight,capacity,depth,height,width));
            }


            if (qName.equals("laptop")) {
                double price = Double.parseDouble(attributes.getValue("price"));
                String os=attributes.getValue("os");
                double batteryCapacity = Double.parseDouble(attributes.getValue("battery-capacity"));
                double memoryRom = Double.parseDouble(attributes.getValue("memory-rom"));
                double systemMemory = Double.parseDouble(attributes.getValue("system-memory"));
                double cpu = Double.parseDouble(attributes.getValue("cpu"));
                double displayInchs = Double.parseDouble(attributes.getValue("display-inchs"));

                appliances.add(new Laptop(price,batteryCapacity,os,memoryRom,systemMemory,cpu,displayInchs));
            }

            if (qName.equals("refrigerator")) {
                double price = Double.parseDouble(attributes.getValue("price"));
                double powerConsumption = Double.parseDouble(attributes.getValue("power-consumption"));
                double weight = Double.parseDouble(attributes.getValue("weight"));
                double freezerCapacity = Double.parseDouble(attributes.getValue("freezer-capacity"));
                double overallCapacity = Double.parseDouble(attributes.getValue("overall-capacity"));
                double height = Double.parseDouble(attributes.getValue("height"));
                double width = Double.parseDouble(attributes.getValue("width"));

                appliances.add(new Refrigerator(price,powerConsumption, weight,freezerCapacity,overallCapacity,height,width));
            }

            if (qName.equals("speaker")) {
                double price = Double.parseDouble(attributes.getValue("price"));
                double powerConsumption = Double.parseDouble(attributes.getValue("power-consumption"));
                int numberOfSpeakers = Integer.parseInt(attributes.getValue("number-of-speakers"));
                String frequencyRange = attributes.getValue("frequency-range");
                double cordLength = Double.parseDouble(attributes.getValue("cord-length"));

                appliances.add(new Speakers(price,powerConsumption, numberOfSpeakers,frequencyRange,cordLength));
            }

            if (qName.equals("tablet-pc")) {
                double price = Double.parseDouble(attributes.getValue("price"));
                double batteryCapacity = Double.parseDouble(attributes.getValue("battery-capacity"));
                double displayInches = Double.parseDouble(attributes.getValue("display-inches"));
                double memoryRom = Double.parseDouble(attributes.getValue("memory-rom"));
                double flashMemoryCapacity = Double.parseDouble(attributes.getValue("flash-memory-capacity"));
                String color = attributes.getValue("color");


                appliances.add(new TabletPC(price,batteryCapacity,displayInches,memoryRom,flashMemoryCapacity,color));
            }

            if (qName.equals("vacuum-cleaner")) {
                double price = Double.parseDouble(attributes.getValue("price"));
                double powerConsumption = Double.parseDouble(attributes.getValue("power-consumption"));
                String filterType = attributes.getValue("filter-type");
                String bagType = attributes.getValue("bag-type");
                String wandType = attributes.getValue("wand-type");
                double motorSpeedRegulation = Double.parseDouble(attributes.getValue("motor-speed-regulation"));
                double cleaningWidth = Double.parseDouble(attributes.getValue("cleaning-width"));

                appliances.add(new VacuumCleaner(price,powerConsumption,filterType,bagType,wandType,motorSpeedRegulation,cleaningWidth));
            }

        }


    }
}
