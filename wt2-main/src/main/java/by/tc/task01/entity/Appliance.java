package by.tc.task01.entity;

/**
 * базовый класс приборов
 */
public abstract class Appliance {
    /**
     * общее для всех приборов поле цена
     */
    protected double price;

    /**
     * геттер цены
     * @return цена прибора
     */
    public double getPrice() {
        return price;
    }

    /**
     * сеттер цены
     * @param price цена прибора
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
