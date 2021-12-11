package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

import java.util.List;
/**
 * класс-реализация сервиса приборов
 */
public class ApplianceServiceImpl implements ApplianceService{

	/**
	 * метод поиска приборов по критериям
	 * @param criteria критерии для поиска
	 * @return список приборов соответствующих критериям
	 */
	@Override
	public List<Appliance> find(Criteria criteria) {
		if (!Validator.criteriaValidator(criteria)) {
			return null;
		}

		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();


		return applianceDAO.find(criteria);
	}

	/**
	 * метод поиска самого дешёвого прибора по группе
	 * @param groupName группа принадлежности прибора
	 * @return самый дешёвый прибор в заданной группе
	 */
	@Override
	public Appliance findCheapest(String groupName) {
		List<Appliance> appliances;
		if(groupName.equals("")){
			appliances=find(new Criteria(""));
		}else {
			appliances=find(new Criteria(groupName));
		}
		if(appliances==null){
			return null;
		}
		int indexOfMin=0;
		double min=appliances.get(0).getPrice();
		for (int i = 1; i <appliances.size(); i++) {
			if(appliances.get(i).getPrice()<min){
				min=appliances.get(i).getPrice();
				indexOfMin=i;
			}
		}
		return appliances.get(indexOfMin);
	}
}


