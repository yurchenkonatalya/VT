package by.epamtc.LAB1.javaFundamentals.task3.run;

import by.epamtc.LAB1.javaFundamentals.task3.util.entity.Element;
import by.epamtc.LAB1.javaFundamentals.task3.util.logic.CreatingElementsArray;
import by.epamtc.LAB1.javaFundamentals.task3.util.logic.Logic;
import by.epamtc.LAB1.javaFundamentals.task3.util.logic.Print;
import by.epamtc.LAB1.javaFundamentals.task3.util.logic.function.FunctionTan;

public class Main {
    public static void main(String[] args) {

        Logic.drawTable(1,5,1.3);

        double a=-1;
        double b=35;
        double h=10;

        CreatingElementsArray creatingElementsArray = new CreatingElementsArray();
        Element mas[]=creatingElementsArray.calculateFunction(a,b,h,new FunctionTan());
        Print.drawTable(mas);
    }
}
