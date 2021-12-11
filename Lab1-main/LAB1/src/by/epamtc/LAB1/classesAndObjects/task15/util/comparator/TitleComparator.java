package by.epamtc.LAB1.classesAndObjects.task15.util.comparator;

import by.epamtc.LAB1.classesAndObjects.task15.util.Book;

import java.util.Comparator;

public class TitleComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
