package pl.edu.utp.collections;

import pl.edu.utp.collections.models.Book;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {

    public static void main(String[] args) {
        Deque<Book> books = new ArrayDeque<>();

        tryAddFirstElement(books, new Book("Java tips and tricks", 150));
        tryAddFirstElement(books, new Book("C++ tips and tricks", 150));
        System.out.println(books);

        tryAddLastElement(books, new Book("Typescript tutorial", 100));
        System.out.println(books);
    }

    public static void tryAddFirstElement(Deque<Book> books, Book book) {
        try {
            boolean accepted = books.offerFirst(book);
            System.out.println("Book offered; accepted? " + accepted);
            books.addFirst(book);
        } catch (IllegalStateException ex) {
            System.err.println("book store is full :(");
        }
    }

    public static void tryAddLastElement(Deque<Book> books, Book book) {
        try {
            boolean accepted = books.offerLast(book);
            System.out.println("Book offered; accepted? " + accepted);
            books.addLast(book); //equivalent to books.add(book);
        } catch (IllegalStateException ex) {
            System.err.println("book store is full :(");
        }
    }

}
