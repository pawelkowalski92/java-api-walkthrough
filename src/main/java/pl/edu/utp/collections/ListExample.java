package pl.edu.utp.collections;

import pl.edu.utp.collections.models.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        // adding elements
        books.add(new Book("Java for dummies", 500));
        books.add(new Book("C++ secrets", 1200));
        System.out.println(books);

        books.add(0, new Book("React for beginners", 80));
        System.out.println(books);

        // getting elements
        listAllBookTitles(books);
        listAllBookTitlesWithIterator(books);

        // overriding elements
        Book jsBook = new Book("JavaScript for experts", 400);
        books.set(1, jsBook);
        System.out.println(books);

        // verifying elements
        System.out.println("Is the JS book in store? " + books.contains(jsBook));

        // removing elements
        books.remove(books.size() - 1); //get rid of the last one in order
        System.out.println(books);

        books.remove(jsBook);
        System.out.println(books);
    }

    public static void listAllBookTitles(List<Book> books) {
        System.out.println("Listing titles with indexed loops");
        /* standard for-loop
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println(book.getTitle());
        }
         */
        // enhanced for-loop
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }

    public static void listAllBookTitlesWithIterator(List<Book> books) {
        System.out.println("Listing titles with iterator");
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()) {
            Book book = bookIterator.next();
            System.out.println(book.getTitle());
        }
    }

}
