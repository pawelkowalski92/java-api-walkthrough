package pl.edu.utp.collections;

import pl.edu.utp.collections.models.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingExample {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book("Java for everyone", 250));
        books.add(new Book("Java for everyone", 200));
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

        // anonymous class
        Comparator<Book> compareByTitleReversed = new Comparator<Book>() {
            /*
            if returns negative:
            {book}, {other}
            if returns positive:
            {other}, {book}
            if returns 0:
            {this} == {other} (treated as equals)
             */
            @Override
            public int compare(Book book, Book other) {
                return other.getTitle().compareTo(book.getTitle());
            }
        };

        // anonymous class as lambda expression
        Comparator<Book> compareByTitleReversedAsLambda = (book, other) -> other.getTitle().compareTo(book.getTitle());

        // powerful comparators using method references, lambdas and comparator functions
        Comparator<Book> compareByTitleAndPageCountReversed = Comparator.comparing(Book::getTitle)
                .thenComparingInt(Book::getPageCount)
                .reversed();

        books.sort(compareByTitleAndPageCountReversed);
        System.out.println("Custom order (by title and page count reversed)");
        System.out.println(books);
    }

}
