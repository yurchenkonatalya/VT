package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * класс для описания запрашиваемых объектов
 */
public class Criteria {
	/**
	 * группа иденцифицирующая тип запрашиваемого объекта
	 */
	private String groupSearchName;
	/**
	 * критерии для поиска
	 */
	private Map<String, Object> criteria = new HashMap<String, Object>();

	/**
	 * конструктор класса
	 * @param groupSearchName значение группы иденцифицирующей тип запрашиваемого объекта
	 */
	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}

	/**
	 * @return значение группы иденцифицирующей тип запрашиваемого объекта
	 */
	public String getGroupSearchName() {
		return groupSearchName;
	}

	/**
	 * добавление критерия для поиска
	 * @param searchCriteria ключ
	 * @param value значение
	 */
	public void add(String searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}

	/**
	 * @return  количество критерий для сравнения
	 */
	public int criteriaSize(){
		return criteria.size();
	}

	/**
	 * @param key ключ
	 * @return значение по ключу
	 */
	public Object get(String key){
		return criteria.get(key);
	}

	/**
	 * @return множество ключей
	 */
	public Set<String> getKeysSet(){
		return criteria.keySet();
	}

}
