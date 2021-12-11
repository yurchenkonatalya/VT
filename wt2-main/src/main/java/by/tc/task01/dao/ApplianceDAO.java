package by.tc.task01.dao;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.List;

/**
 * интерфейс доступа к данным
 */
public interface ApplianceDAO {
	/**
	 * метод поиска приборов по критериям
	 * @param criteria объект критериев для поиска
	 * @return список приборов подходящих по заданным критериям
	 */
	List<Appliance> find(Criteria criteria);
}
