package by.epamtc.LAB1.classesAndObjects.task14.run;

import by.epamtc.LAB1.classesAndObjects.task14.util.Book;
import by.epamtc.LAB1.classesAndObjects.task14.util.SortShell;

import java.util.Arrays;

public class Main {
    public static void main(String []args){
        Book mas[]={new Book("a",4),new Book("b",4),new Book("c",8),new Book("d",1),
                new Book("e",5),new Book("f",0),new Book("g",3)};
        SortShell.sort(mas);
        System.out.println(Arrays.toString(mas));
    }
}
