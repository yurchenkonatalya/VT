package by.tc.task01.service;

import by.tc.task01.service.impl.ApplianceServiceImpl;

/**
 * класс-фабрика для создания класса-сервиса приборов
 */
public final class ServiceFactory {

	/**
	 * создание экземпляра данного класса
	 */
	private static final ServiceFactory instance = new ServiceFactory();
	/**
	 * создание класса-сервиса приборов
	 */
	private final ApplianceService applianceService = new ApplianceServiceImpl();
	/**
	 * приватный конструктор класса
	 */
	private ServiceFactory() {}
	/**
	 * геттер класса-сервиса приборов
	 * @return класс-сервис приборов
	 */
	public ApplianceService getApplianceService() {
		return applianceService;
	}

	/**
	 * геттер экземпляра данного класса
	 * @return экземпляр данного класса
	 */
	public static ServiceFactory getInstance() {
		return instance;
	}

}
