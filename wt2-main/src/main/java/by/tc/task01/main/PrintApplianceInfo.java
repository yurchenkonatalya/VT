package by.tc.task01.main;

import by.tc.task01.entity.Appliance;
import by.tc.task01.service.control.ApplianceController;
import by.tc.task01.service.control.factory.ControllerFactory;

/**
 * класс для текстового представления данных о приборах
 */
public class PrintApplianceInfo {
	/**
	 * метод вывода данных о приборе
	 * @param appliance прибор
	 */
	public static void print(Appliance appliance) {
		ControllerFactory controllerFactory=ControllerFactory.getInstance();
		ApplianceController applianceController=controllerFactory.takeApplianceConrtoller(appliance);
		System.out.println(applianceController.takeInfo());
		
	}


}
