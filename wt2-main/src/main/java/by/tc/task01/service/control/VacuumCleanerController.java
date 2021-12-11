package by.tc.task01.service.control;


import by.tc.task01.entity.VacuumCleaner;
/**
 * класс-контроллер пылесоса аналогичен классу-контроллеру ноутбука
 */
public class VacuumCleanerController extends ApplianceController{
    private VacuumCleaner vacuumCleaner;

    public VacuumCleanerController(VacuumCleaner vacuumCleaner) {
        this.vacuumCleaner = vacuumCleaner;
    }

    @Override
    public String takeInfo() {
        return this.vacuumCleaner.toString();
    }

    @Override
    public boolean isContainsValue(String key, Object value) {
        boolean answer=true;
        switch (key){
            case "PRICE":
                if(!(vacuumCleaner.getPrice()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "POWER_CONSUMPTION":
                if(!(vacuumCleaner.getPowerConsumption()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "FILTER_TYPE":
                if(!(vacuumCleaner.getFilterType().equals(value.toString()))){
                    answer=false;
                }
                break;
            case "BAG_TYPE":
                if(!(vacuumCleaner.getBagType().equals(value.toString()))){
                    answer=false;
                }
                break;
            case "WAND_TYPE":
                if(!(vacuumCleaner.getWandType().equals(value.toString()))){
                    answer=false;
                }
                break;
            case "MOTOR_SPEED_REGULATION":
                if(!(vacuumCleaner.getMotorSpeedRegulation()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "CLEANING_WIDTH":
                if(!(vacuumCleaner.getCleaningWidth()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;

            default:
                answer=false;
        }
        return answer;
    }
}
