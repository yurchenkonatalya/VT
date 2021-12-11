package by.epamtc.LAB1.javaFundamentals.task3.util.entity;

import java.io.Serializable;

public class Element implements Serializable {

    private double x;
    private double fx;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getFx() {
        return fx;
    }

    public void setFx(double fx) {
        this.fx = fx;
    }

    public Element(double x, double fx) {
        this.x = x;
        this.fx = fx;
    }

    public Element() {
    }
}
