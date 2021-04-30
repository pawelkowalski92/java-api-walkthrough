package pl.edu.utp.collections;

import pl.edu.utp.collections.models.Book;
import pl.edu.utp.collections.models.FantasyBook;

import java.util.*;

public class WrapperClasses {

    public static void main(String[] args) {
        // type parameters in collections - only objects
        List<String> strings;
        Queue<Double> doubles;
        Deque<Integer> ints;
        Set<Character> chars;

        Map<Integer, String> intsToStrings;

        // cannot use primitive as type parameter
        // Set<char> charsPrm;

        // wrapper classes - how to
        ints = new ArrayDeque<>();
        ints.add(new Integer(1)); // don't do that
        ints.add(2); // boxing: ints.add(Integer.valueOf(2));

        int a = 3;
        ints.add(a); // boxing: ints.add(Integer.valueOf(a));

        System.out.println(ints);

        Integer b = ints.getFirst();
        System.out.println(b);

        int c = ints.getLast(); // unboxing: int c = ints.getLast().intValue();
        System.out.println(c);

        int result = addInts(a, c); // autoboxing: addInts(Integer.valueOf(a), Integer.valueOf(c));
        System.out.println("Sum: " + result);

        // a small recap on method overloading

        int res1 = addInts(10, 20); // ?
        System.out.println(res1);

        int res2 = addInts(Integer.valueOf(1), Integer.valueOf(2)); // ?
        System.out.println(res2);

        // method used in overloading depends on the reference the object is assigned to
        Book book = new Book("a", 1);
        Book fantasyBook = new FantasyBook("b", 2);

        System.out.println("Book description: " + getDescription(book));
        System.out.println("Fantasy book description: " + getDescription(fantasyBook));
    }

    public static int addInts(Integer a, Integer b) {
        System.out.println("objects");
        return a + b;
    }

    public static int addInts(int a, int b) {
        System.out.println("primitives");
        return a + b;
    }

    public static String getDescription(Object object) {
        System.out.println("from object");
        return object.toString();
    }

    public static String getDescription(Book book) {
        System.out.println("from book");
        return book.toString();
    }

    public static String getDescription(FantasyBook fantasyBook) {
        System.out.println("from fantasy book");
        return fantasyBook.toString();
    }

}
