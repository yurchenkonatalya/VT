package by.tc.task01.service.control.factory;

import by.tc.task01.entity.*;
import by.tc.task01.service.control.*;

/**
 * класс-фабрика контроллеров приборов
 */
public class ControllerFactory {
    /**
     * создание экземпляра данного класса
     */
    private static final ControllerFactory instance = new ControllerFactory();
    /**
     * приватный конструктор класса
     */
    private ControllerFactory() {}
    /**
     * геттер экземпляра данного класса
     * @return экземпляр данного класса
     */
    public static ControllerFactory getInstance() {
        return instance;
    }

    /**
     * метод получения класса-контроллера для прибора
     * @param appliance прибор
     * @return контроллер прибора
     */
    public ApplianceController takeApplianceConrtoller(Appliance appliance) {
        ApplianceController applianceController=null;

        if(appliance.getClass()== Oven.class){
            applianceController=new OvenController((Oven) appliance);
        }
        if(appliance.getClass()== Laptop.class){
            applianceController=new LaptopController((Laptop) appliance);
        }
        if(appliance.getClass()== Refrigerator.class){
            applianceController=new RefrigeratorController((Refrigerator) appliance);
        }
        if(appliance.getClass()== Speakers.class){
            applianceController=new SpeakersController((Speakers) appliance);
        }
        if(appliance.getClass()== TabletPC.class){
            applianceController=new TabelPCController((TabletPC) appliance);
        }
        if(appliance.getClass()== VacuumCleaner.class){
            applianceController=new VacuumCleanerController((VacuumCleaner) appliance);
        }

        return applianceController;
    }

}
