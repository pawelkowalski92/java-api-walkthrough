package pl.edu.utp.collections;

import pl.edu.utp.collections.models.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingExample {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book("Java for everyone", 250));
        books.add(new Book("C++ for everyone", 250));
        books.add(new Book("Typescript for advanced", 400));

        System.out.println("Input order");
        System.out.println(books);

        books.sort(null); // equivalent to Collections.sort(books);
        System.out.println("Natural order");
        System.out.println(books);

        Collections.reverse(books);
        System.out.println("Reversed order");
        System.out.println(books);
    }

}
