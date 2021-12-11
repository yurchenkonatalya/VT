package by.tc.task01.entity.criteria;

/**
 * класс содержащий все возможные критерии запроса
 */
public final class SearchCriteria {
	/**
	 * все возможные критерии запроса микроволновки
	 */
	public static enum Oven{
		PRICE,POWER_CONSUMPTION, WEIGHT, CAPACITY, DEPTH, HEIGHT, WIDTH
	}
	/**
	 * все возможные критерии запроса ноутбука
	 */
	public static enum Laptop{
		PRICE,BATTERY_CAPACITY, OS, MEMORY_ROM, SYSTEM_MEMORY, CPU, DISPLAY_INCHS
	}
	/**
	 * все возможные критерии запроса холодильника
	 */
	public static enum Refrigerator{
		PRICE,POWER_CONSUMPTION, WEIGHT, FREEZER_CAPACITY, OVERALL_CAPACITY, HEIGHT, WIDTH
	}
	/**
	 * все возможные критерии запроса пылесоса
	 */
	public static enum VacuumCleaner{
		PRICE,POWER_CONSUMPTION, FILTER_TYPE, BAG_TYPE, WAND_TYPE, MOTOR_SPEED_REGULATION, CLEANING_WIDTH
	}
	/**
	 * все возможные критерии запроса планшета
	 */
	public static enum TabletPC{
		PRICE,BATTERY_CAPACITY, DISPLAY_INCHES, MEMORY_ROM, FLASH_MEMORY_CAPACITY, COLOR
	}
	/**
	 * все возможные критерии запроса колонок
	 */
	public static enum Speakers{
		PRICE,POWER_CONSUMPTION, NUMBER_OF_SPEAKERS, FREQUENCY_RANGE, CORD_LENGTH
	}

	/**
	 * конструктор класса
	 */
	private SearchCriteria() {}
}

