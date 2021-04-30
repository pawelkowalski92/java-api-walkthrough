package pl.edu.utp.collections;

import pl.edu.utp.collections.models.Book;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueExample {

    public static void main(String[] args) {
        Queue<Book> bookStack = new ArrayDeque<>();
        // examine elements on empty queue
        try {
            System.out.println(bookStack.peek());
            System.out.println(bookStack.element());
        } catch (NoSuchElementException ex) {
            System.out.println("bookStack.element() has no elements :(");
        }

        // remove elements from empty queue
        try {
            System.out.println(bookStack.poll());
            System.out.println(bookStack.remove());
        } catch (NoSuchElementException ex) {
            System.out.println("bookStack.remove() has no elements to remove :(");
        }

        // add element
        addToQueue(bookStack);

        printAllBooks(bookStack);
        System.out.println(bookStack);

        printAllBooksNoIterator(bookStack);
        System.out.println(bookStack);

        // queue with limited size
        Queue<Book> sizeLimited = new ArrayBlockingQueue<>(1);
        addToQueue(sizeLimited);
        addToQueue(sizeLimited);
    }

    public static void printAllBooks(Queue<Book> bookStack)  {
        for (Book book : bookStack) {
            System.out.println(book);
        }
    }

    public static void printAllBooksNoIterator(Queue<Book> bookStack) {
        for (Book book = bookStack.poll(); book != null; book = bookStack.poll()) {
            System.out.println(book);
        }
    }

    public static void addToQueue(Queue<Book> bookStack) {
        // add element
        try {
            boolean didAdd = bookStack.add(new Book("HTML for architects", 5));
            boolean didOffer = bookStack.offer(new Book("CSS for architects", 5));
            System.out.println("Add? " + didAdd);
            System.out.println("Offer? " + didOffer);
        } catch (IllegalStateException ex) {
            System.out.println("bookStack.add() has no capacity to add new elements");
        }
    }

}
