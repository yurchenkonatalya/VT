package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *класс  Main точка входа в приложение
 */
public class Main {

	/**
	 * метод с которого стартует приложение
	 * @param args аргументы переданные в консоли
	 */
	public static void main(String[] args) {

		List<Appliance> appliances;
		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();


		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
		criteriaOven.add(Oven.PRICE.toString(), 15);



		appliances = service.find(criteriaOven);

		for (int i = 0; i <appliances.size(); i++) {
			PrintApplianceInfo.print(appliances.get(i));
		}
		System.out.println("---------------------------------------------------------------------------");


		//////////////////////////////////////////////////////////////////
		criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(Oven.PRICE.toString(), 15);
		criteriaOven.add(Oven.DEPTH.toString(), 80);

		appliances = service.find(criteriaOven);

		for (int i = 0; i <appliances.size(); i++) {
			PrintApplianceInfo.print(appliances.get(i));
		}
		System.out.println("---------------------------------------------------------------------------");


		//////////////////////////////////////////////////////////////////
		
		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
		criteriaTabletPC.add(TabletPC.COLOR.toString(), "BLUE");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 4);

		appliances = service.find(criteriaTabletPC);

		for (int i = 0; i <appliances.size(); i++) {
			PrintApplianceInfo.print(appliances.get(i));
		}
		System.out.println("---------------------------------------------------------------------------");


		System.out.println("Вывод всех пылесосов");
		appliances=service.find(new Criteria(VacuumCleaner.class.getSimpleName()));
		for (int i = 0; i <appliances.size(); i++) {
			PrintApplianceInfo.print(appliances.get(i));
		}
		System.out.println("Вывод самого дешёвого товара");
		PrintApplianceInfo.print(service.findCheapest(""));
		System.out.println("Вывод самой дешёвой микроволновки");
		PrintApplianceInfo.print(service.findCheapest(Oven.class.getSimpleName()));

	}

}
