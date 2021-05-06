package pl.edu.utp.collections;

import pl.edu.utp.collections.models.Book;

import java.util.HashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {
        Set<Book> books = new HashSet<>();

        books.add(new Book("Java for beginners", 100));
        books.add(new Book("C++ for advanced programmers", 200));
        books.add(new Book("Java for beginners", 100));

        System.out.println(books);

        Book typescript = new Book("Typescript tutorial", 50);

        books.add(typescript);

        System.out.println(books);
        listSetElements(books);

        books.remove(new Book("Typescript tutorial", 50));
        System.out.println(books);

        books.remove(typescript);
        System.out.println(books);

        boolean hasJavaBook = books.contains(new Book("Java for beginners", 100));
        System.out.println("Has Java book? " + hasJavaBook);
    }

    public static void listSetElements(Set<Book> set) {
        for (Book element : set) {
            System.out.println(element);
        }
    }

}
