package by.tc.task01.entity;

import java.io.Serializable;
import java.util.Objects;
/**
 * класс пылесоса по аналогии с ноутбуком
 */
public class VacuumCleaner extends Appliance implements Serializable {
    private double powerConsumption;
    private String filterType;
    private String bagType;
    private String wandType;
    private double motorSpeedRegulation;
    private double cleaningWidth;

    public VacuumCleaner(){

    }

    public VacuumCleaner(double price, double powerConsumption, String filterType, String bagType, String wandType, double motorSpeedRegulation, double cleaningWidth) {
        super.price=price;
        this.powerConsumption = powerConsumption;
        this.filterType = filterType;
        this.bagType = bagType;
        this.wandType = wandType;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public double getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(double motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public double getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(double cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacuumCleaner that = (VacuumCleaner) o;
        return Double.compare(that.powerConsumption, powerConsumption) == 0
                && Double.compare(that.price, price) == 0
                && Double.compare(that.motorSpeedRegulation, motorSpeedRegulation) == 0
                && Double.compare(that.cleaningWidth, cleaningWidth) == 0
                && filterType.equals(that.filterType)
                && bagType.equals(that.bagType)
                && wandType.equals(that.wandType);
    }

    @Override
    public int hashCode() {
        return (int)(31*price+29*powerConsumption+Objects.hash(filterType,bagType,wandType)
                +23*motorSpeedRegulation+13*cleaningWidth);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"{" +
                "price=" + price +
                "powerConsumption=" + powerConsumption +
                ", filterType='" + filterType  +
                ", bagType='" + bagType +
                ", wandType='" + wandType +
                ", motorSpeedRegulation=" + motorSpeedRegulation +
                ", cleaningWidth=" + cleaningWidth +
                ", price=" + price +
                '}';
    }
}