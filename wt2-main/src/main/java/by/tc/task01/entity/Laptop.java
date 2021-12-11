package by.tc.task01.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * класс-сущность хранит данные о ноутбуках
 */
public class Laptop extends Appliance implements Serializable {

    /**
     * вместительность батареи
     */
    private double batteryCapacity;
    /**
     * операционная система
     */
    private String operationSystem;
    /**
     * количество оперативной памяти
     */
    private double memoryROM;
    /**
     * количество системной памяти
     */
    private double systemMemory;
    /**
     * версия процессора
     */
    private double cpu;
    /**
     *количество дюймов
     */
    private double displayInchs;

    /**
     * конструктор класса
     */
    public Laptop(){

    }

    /**
     * конструктор класса
     * @param price цена
     * @param batteryCapacity вместительность батареи
     * @param operationSystem операционная система
     * @param memoryROM оперативная память
     * @param systemMemory количество системной памяти
     * @param cpu версия процессора
     * @param displayInchs количество дюймов
     */
    public Laptop(double price,double batteryCapacity, String operationSystem, double memoryROM, double systemMemory, double cpu, double displayInchs) {
        super.price=price;
        this.batteryCapacity = batteryCapacity;
        this.operationSystem = operationSystem;
        this.memoryROM = memoryROM;
        this.systemMemory = systemMemory;
        this.cpu = cpu;
        this.displayInchs = displayInchs;
    }

    /**
     * геттер вместительности батареи
     * @return вместительность батареи
     */
    public double getBatteryCapacity() {
        return batteryCapacity;
    }
    /**
     * сеттер вместительности батареи
     * @return вместительность батареи
     */
    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    /**
     * геттер операционной системы
     * @return операционная система
     */
    public String getOperationSystem() {
        return operationSystem;
    }
    /**
     * сеттер операционной системы
     * @return операционная система
     */
    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    /**
     * геттер оперативной памяти
     * @return оперативная память
     */
    public double getMemoryROM() {
        return memoryROM;
    }
    /**
     * сеттер оперативной памяти
     * @return оперативная память
     */
    public void setMemoryROM(double memoryROM) {
        this.memoryROM = memoryROM;
    }

    /**
     * геттер количества системной памяти
     * @return количество системной памяти
     */
    public double getSystemMemory() {
        return systemMemory;
    }
    /**
     * сеттер количества системной памяти
     * @return количество системной памяти
     */
    public void setSystemMemory(double systemMemory) {
        this.systemMemory = systemMemory;
    }

    /**
     * геттер версии процессора
     * @return версия процессора
     */
    public double getCpu() {
        return cpu;
    }
    /**
     * сеттер версии процессора
     * @return версия процессора
     */
    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    /**
     * геттер количества дюймов
     * @return количество дюймов
     */
    public double getDisplayInchs() {
        return displayInchs;
    }
    /**
     * сеттер количества дюймов
     * @return количество дюймов
     */
    public void setDisplayInchs(double displayInchs) {
        this.displayInchs = displayInchs;
    }

    /**
     * переопределённый метод эквивалентности
     * @param o объект для сравнения
     * @return результат сравнения
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return Double.compare(laptop.batteryCapacity, batteryCapacity) == 0
                && Double.compare(laptop.memoryROM, memoryROM) == 0 &&
                Double.compare(laptop.systemMemory, systemMemory) == 0 &&
                Double.compare(laptop.cpu, cpu) == 0 &&
                Double.compare(laptop.displayInchs, displayInchs) == 0
                && operationSystem.equals(laptop.operationSystem);
    }

    /**
     * переопределённый метод получения хеш-кода
     * @return хеш-код объекта
     */
    @Override
    public int hashCode() {
        return (int)(31*price +29*batteryCapacity +Objects.hashCode(operationSystem)+
                7*memoryROM+13*systemMemory+23*cpu+5*displayInchs);
    }

    /**
     * переопределённый метод строкового представления объекта
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return getClass().getSimpleName()+"{" +
                "price=" + price +
                "batteryCapacity=" + batteryCapacity +
                ", operationSystem='" + operationSystem  +
                ", memoryROM=" + memoryROM +
                ", systemMemory=" + systemMemory +
                ", cpu=" + cpu +
                ", displayInchs=" + displayInchs +
                ", price=" + price +
                '}';
    }
}
