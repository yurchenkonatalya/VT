package by.epamtc.LAB1.javaFundamentals.task7.run;

import by.epamtc.LAB1.javaFundamentals.task7.util.SortShell;

import java.util.Arrays;

public class Main {
    public static void main(String [] args){
        double[] mas ={4,3,2,1,52,5321,31,3152,1623,1412,412,412,4,124,1,4,124,567,235,1351};
        SortShell.sort(mas);
        System.out.println(Arrays.toString(mas));
    }
}
