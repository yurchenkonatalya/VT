package by.tc.task01.service;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.List;
/**
 * интерфейс методов по работе с приборами
 */
public interface ApplianceService {
	/**
	 * метод поиска приборов по критериям
	 * @param criteria критерии для поиска
	 * @return список приборов соответствующих критериям
	 */
	List<Appliance> find(Criteria criteria);

	/**
	 * метод поиска самого дешёвого прибора по группе
	 * @param groupName группа принадлежности прибора
	 * @return самый дешёвый прибор в заданной группе
	 */
	Appliance findCheapest(String groupName);
}
