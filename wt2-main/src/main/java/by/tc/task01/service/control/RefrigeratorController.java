package by.tc.task01.service.control;

import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
/**
 * класс-контроллер холодильника аналогичен классу-контроллеру ноутбука
 */
public class RefrigeratorController extends ApplianceController{
    private Refrigerator refrigerator;

    public RefrigeratorController(Refrigerator refrigerator) {
        this.refrigerator = refrigerator;
    }

    @Override
    public String takeInfo() {
        return this.refrigerator.toString();
    }

    @Override
    public boolean isContainsValue(String key, Object value) {
        boolean answer=true;
        switch (key){
            case "PRICE":
                if(!(refrigerator.getPrice()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "POWER_CONSUMPTION":
                if(!(refrigerator.getPowerConsumption()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "WEIGHT":
                if(!(refrigerator.getWeight()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "FREEZER_CAPACITY":
                if(!(refrigerator.getFreezerCapacity()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "OVERALL_CAPACITY":
                if(!(refrigerator.getOverallCapacity()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "HEIGHT":
                if(!(refrigerator.getHeight()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "WIDTH":
                if(!(refrigerator.getWidth()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;

            default:
                answer=false;
        }
        return answer;
    }
}
