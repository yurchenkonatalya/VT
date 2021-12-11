package by.tc.task01.service.control;


/**
 * базовый класс-контроллер приборов
 */
public abstract class ApplianceController {
    /**
     * метод получения информации о приборе
     * @return строковое представление информации о приборе
     */
    public abstract String takeInfo();

    /**
     * метод проверки на наличии конкретного критерия у данного прибора
     * @param key ключ критерия
     * @param value значение критерия
     * @return результат проверки
     */
    public abstract boolean isContainsValue(String key,Object value);


}
