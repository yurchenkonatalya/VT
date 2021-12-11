package by.epamtc.LAB1.javaFundamentals.task3.util.logic;

public class Logic {

    public static void drawTable(double a, double b, double h){
        System.out.println("x   |f(x)");
        while(a<=b){
            System.out.printf("%.2f|%.2f\n",a,calculateFunction(a+h));
            a+=h;
        }
    }

    static double calculateFunction(double x){
        return Math.tan(x);
    }
}
