package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.dao.impl.parser.XMLParserImpl;
import by.tc.task01.dao.impl.parser.XMLParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * класс-реализация доступа к данным
 */
public class ApplianceDAOImpl implements ApplianceDAO{

	/**
	 * метод поиска приборов по критериям
	 * @param criteria объект критериев для поиска
	 * @return список приборов подходящих по заданным критериям
	 */
	@Override
	public List<Appliance> find(Criteria criteria) {
		XMLParser parser=new XMLParserImpl();
		try {
			parser.parse("src/main/resources/file.xml");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		return parser.take(criteria);
	}
	

}
