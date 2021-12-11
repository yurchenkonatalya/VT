package by.tc.task01.service.control;

import by.tc.task01.entity.Oven;
import by.tc.task01.entity.TabletPC;
/**
 * класс-контроллер планшета аналогичен классу-контроллеру ноутбука
 */
public class TabelPCController extends ApplianceController{
    private TabletPC tabletPC;

    public TabelPCController(TabletPC tabletPC) {
        this.tabletPC = tabletPC;
    }

    @Override
    public String takeInfo() {
        return this.tabletPC.toString();
    }

    @Override
    public boolean isContainsValue(String key, Object value) {
        boolean answer=true;
        switch (key){
            case "PRICE":
                if(!(tabletPC.getPrice()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "BATTERY_CAPACITY":
                if(!(tabletPC.getBatteryCapacity()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "DISPLAY_INCHES":
                if(!(tabletPC.getDisplayInches()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "MEMORY_ROM":
                if(!(tabletPC.getMemoryROM()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "FLASH_MEMORY_CAPACITY":
                if(!(tabletPC.getFlashMemoryCapacity()==Double.parseDouble(value.toString()))){
                    answer=false;
                }
                break;
            case "COLOR":
                if(!(tabletPC.getColor().equals(value.toString()))){
                    answer=false;
                }
                break;

            default:
                answer=false;
        }
        return answer;
    }
}
