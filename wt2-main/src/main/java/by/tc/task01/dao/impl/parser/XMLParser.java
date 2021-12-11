package by.tc.task01.dao.impl.parser;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
/**
 * интерфейс парсера XML
 */
public interface XMLParser {
    /**
     * метод парсинга файла
     * @param path путь к файлу
     * @throws ParserConfigurationException ошибка конфигурации парсера
     * @throws SAXException ошибка парсера типа SAX
     * @throws IOException ошибка ввода-вывода
     */
    void parse(String path) throws ParserConfigurationException, SAXException, IOException;

    /**
     * метод получения приборов по заданным критериям
     * @param criteria критерии прибора
     * @return список приборов по заданным критериям
     */
    List<Appliance> take(Criteria criteria);
}
