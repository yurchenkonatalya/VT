package by.epamtc.LAB1.classesAndObjects.task15.run;

import by.epamtc.LAB1.classesAndObjects.task15.util.Book;
import by.epamtc.LAB1.classesAndObjects.task15.util.SortShell;
import by.epamtc.LAB1.classesAndObjects.task15.util.comparator.AuthorComparator;
import by.epamtc.LAB1.classesAndObjects.task15.util.comparator.PriceComparator;
import by.epamtc.LAB1.classesAndObjects.task15.util.comparator.TitleComparator;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args){

        Comparator<Book> titleComparator=new TitleComparator();
        Comparator<Book> titleAuthorComparator=new TitleComparator().thenComparing(new AuthorComparator());
        Comparator<Book> authorTitleComparator=new AuthorComparator().thenComparing(new TitleComparator());
        Comparator<Book> authorTitlePriceComparator=new AuthorComparator().thenComparing(new TitleComparator().thenComparing(new PriceComparator()));

        ArrayList<Book> bookArrayList=new ArrayList<Book>();

        bookArrayList.add(new Book("title4","author3",14));
        bookArrayList.add(new Book("title3","author6",9));
        bookArrayList.add(new Book("title2","author0",4));
        bookArrayList.add(new Book("title1","author-1",1));
        bookArrayList.add(new Book("title0","author312",4));

        SortShell.sort(bookArrayList,titleAuthorComparator);
        System.out.println(bookArrayList);
    }
}





