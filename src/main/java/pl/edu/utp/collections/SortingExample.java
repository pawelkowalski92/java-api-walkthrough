package pl.edu.utp.collections;

import pl.edu.utp.collections.models.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingExample {

    public static void main(String[] args) {
        List<String> titles = new ArrayList<>();

        titles.add("Java for everyone");
        titles.add("C++ for everyone");
        titles.add("Typescript for advanced");

        System.out.println("Input order");
        System.out.println(titles);

        Collections.sort(titles); // equivalent to titles.sort(null);
        System.out.println("Natural order");
        System.out.println(titles);

        Collections.reverse(titles);
        System.out.println("Reversed order");
        System.out.println(titles);
    }

}
