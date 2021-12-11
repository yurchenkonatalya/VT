package by.epamtc.LAB1.javaFundamentals.task3.util.logic;

import by.epamtc.LAB1.javaFundamentals.task3.util.entity.Element;
import by.epamtc.LAB1.javaFundamentals.task3.util.logic.function.Function;

public class CreatingElementsArray {

    public Element[] calculateFunction(double a, double b, double h, Function function){
        int n= (int) ((b-a)/h);
        Element []mas=new Element[n];
        for (int i = 0; i <n ; i++) {
            mas[i]=new Element(a,function.calculateFunction(a));
            a+=h;
        }

        return mas;
    }

}
