package by.tc.task01.dao;

import by.tc.task01.dao.impl.ApplianceDAOImpl;

/**
 * класс-фабрика для получения класса-реализации доступа к данным
 */
public final class DAOFactory {
	/**
	 * создание экземпляра данного класса
	 */
	private static final DAOFactory instance = new DAOFactory();
	/**
	 * создание класса-реализации доступа к данным
	 */
	private final ApplianceDAO applianceDAO = new ApplianceDAOImpl();

	/**
	 * приватный конструктор класса
	 */
	private DAOFactory() {}

	/**
	 * геттер класса-реализации доступа к данным
	 * @return класс-реализации доступа к данным
	 */
	public ApplianceDAO getApplianceDAO() {
		return applianceDAO;
	}

	/**
	 * геттер экземпляра данного класса
	 * @return экземпляр данного класса
	 */
	public static DAOFactory getInstance() {
		return instance;
	}
}
