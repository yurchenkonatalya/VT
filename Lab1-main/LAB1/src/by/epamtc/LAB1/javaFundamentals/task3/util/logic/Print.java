package by.epamtc.LAB1.javaFundamentals.task3.util.logic;

import by.epamtc.LAB1.javaFundamentals.task3.util.entity.Element;

public class Print {

    public static void drawTable(Element[] mas) {
        System.out.println("x   |f(x)");
        for (Element ma : mas) {
            System.out.printf("%.2f|%.2f\n", ma.getX(), ma.getFx());
        }
    }

}
