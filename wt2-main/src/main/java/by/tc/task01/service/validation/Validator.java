package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;


import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * класс валидации запрашиваемых критериев
 */
public class Validator {

	/**
	 * метод валидации запрашиваемых критериев
	 * @param criteria критерии
	 * @return результат валидации
	 */
	public static boolean criteriaValidator(Criteria criteria) {

		boolean isValid=true;
		Set<String> keys=criteria.getKeysSet();
		Iterator<String> iterator=keys.iterator();
		while (iterator.hasNext()){
			String key=iterator.next();
			if(!isValueValid(key,criteria.get(key))){
				isValid=false;
				break;
			}
		}
		return isValid;
	}

	/**
	 * метод валидации конкретного критерия
	 * @param key ключ критерия
	 * @param value значение критерия
	 * @return результат валидации критерия
	 */
	private static boolean isValueValid(String key,Object value){
		boolean answer;
		switch (key){
			case "PRICE":
			case "POWER_CONSUMPTION":
			case "WEIGHT":
			case "CAPACITY":
			case "DEPTH":
			case "HEIGHT":
			case "WIDTH":
			case "BATTERY_CAPACITY":
			case "MEMORY_ROM":
			case "SYSTEM_MEMORY":
			case "CPU":
			case "DISPLAY_INCHS":
			case "FREEZER_CAPACITY":
			case "OVERALL_CAPACITY":
			case "MOTOR_SPEED_REGULATION":
			case "CLEANING_WIDTH":
			case "DISPLAY_INCHES":
			case "FLASH_MEMORY_CAPACITY":
			case "CORD_LENGTH":

				answer=isPositiveDouble(value);
				break;
			case "NUMBER_OF_SPEAKERS":
				answer=isPositiveInteder(value);
				break;
			case "OS":
			case "FILTER_TYPE":
			case "BAG_TYPE":
			case "WAND_TYPE":
			case "COLOR":
				answer=!isEmptyString(value);
				break;
			case "FREQUENCY_RANGE":
				answer=isDoubleRange(value);
				break;
			default:
				answer=false;
		}

		return  answer;
	}

	/**
	 * метод проверки на принадлежность к шаблону
	 * @param value строка на проверку принадлежности
	 * @param reg шаблон
	 * @return результат проверки
	 */
	static boolean isMatch(String value,String reg){
		Pattern pattern=Pattern.compile(reg);
		Matcher matcher=pattern.matcher(value);
		return matcher.find();
	}

	/**
	 * метод проверки на положительность целочисленного значения
	 * @param value строка на проверку принадлежности
	 * @return результат проверки
	 */
	static boolean isPositiveInteder(Object value){
		return isMatch(value.toString(),"[1-9]\\d*");
	}
	/**
	 * метод проверки на положительность дробного значения
	 * @param value строка на проверку принадлежности
	 * @return результат проверки
	 */
	static boolean isPositiveDouble(Object value){
		return isMatch(value.toString(),"([1-9]\\d*\\.\\d+)|(0[1-9]*\\.\\d+)|(\\d\\.\\d+)|(0)|([1-9]\\d*)");
	}
	/**
	 * метод проверки на корректность строки
	 * @param value строка на проверку принадлежности
	 * @return результат проверки
	 */
	static boolean isEmptyString(Object value){
		return value.toString().isEmpty();
	}
	/**
	 * метод проверки на корректность диапазона
	 * @param value строка на проверку принадлежности
	 * @return результат проверки
	 */
	static boolean isDoubleRange(Object value){
		boolean answer=isMatch(value.toString(),"(([1-9]\\d*\\.\\d+)|(0[1-9]*\\.\\d+)|(\\d\\.\\d+)|(0)|([1-9]\\d*))-(([1-9]\\d*\\.\\d+)|(0[1-9]*\\.\\d+)|(\\d\\.\\d+)|(0)|([1-9]\\d*))<fv");
		if(answer){
			String[] mas=value.toString().split("-");
			double n1=Double.parseDouble(mas[0]);
			double n2=Double.parseDouble(mas[1]);
			if(n2<=n1){
				answer=false;
			}
		}
		return answer;
	}

}
