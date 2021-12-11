package by.epamtc.LAB1.javaFundamentals.task6.util;

public class Logic {

    public static void printMatrix(double[] mas){
        for (int i = 0; i <mas.length ; i++) {
            for (int j=i;j <mas.length;j++){
                System.out.printf("%.2f ",mas[j]);
            }
            for (int l=0;l<i;l++){
                System.out.printf("%.2f ",mas[l]);
            }
            System.out.println();
        }
    }
}
