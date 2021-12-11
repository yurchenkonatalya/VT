package by.tc.task01.service.control;

import by.tc.task01.entity.Laptop;


/**
 * класс-контроллер ноутбука
 */
public class LaptopController extends ApplianceController{
    /**
     * ноутбук
     */
    private Laptop laptop;

    /**
     * конструктор класса
     * @param laptop ноутбук
     */
    public LaptopController(Laptop laptop) {
        this.laptop = laptop;
    }
    /**
     * метод получения информации о приборе
     * @return строковое представление информации о приборе
     */
    @Override
    public String takeInfo() {
        return this.laptop.toString();
    }
    /**
     * метод проверки на наличии конкретного критерия у данного прибора
     * @param key ключ критерия
     * @param value значение критерия
     * @return результат проверки
     */
    @Override
    public boolean isContainsValue(String key, Object value) {
        boolean answer=true;
        switch (key){
            case "PRICE":
                if(!(laptop.getPrice()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "BATTERY_CAPACITY":
                if(!(laptop.getBatteryCapacity()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "OS":
                if(!(laptop.getOperationSystem().equals(value.toString()))){
                    answer=false;
                }
                break;
            case "MEMORY_ROM":
                if(!(laptop.getMemoryROM()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "SYSTEM_MEMORY":
                if(!(laptop.getSystemMemory()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "CPU":
                if(!(laptop.getCpu()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "DISPLAY_INCHS":
                if(!(laptop.getDisplayInchs()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;

            default:
                answer=false;
        }
        return answer;
    }
}
