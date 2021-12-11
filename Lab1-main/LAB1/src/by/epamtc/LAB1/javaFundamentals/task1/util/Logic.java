package by.epamtc.LAB1.javaFundamentals.task1.util;

public class Logic {
    public static double calculate(double x, double y){

        double numerator=1+Math.sin(x+y)*Math.sin(x+y);

        return numerator/(2+Math.abs(x-2*x/(1+x*x*y*y)))+x;
    }
}
