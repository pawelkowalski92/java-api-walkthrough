package pl.edu.utp.collections;

import java.util.HashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {
        Set<String> titles = new HashSet<>();

        titles.add("Java for beginners");
        titles.add("C++ for advanced programmers");
        titles.add("Java for beginners");

        System.out.println(titles);

        titles.add("Typescript tutorial");

        System.out.println(titles);
        listSetElements(titles);

        titles.remove("Typescript tutorial");
        System.out.println(titles);
    }

    public static void listSetElements(Set<String> set) {
        for (String element : set) {
            System.out.println(element);
        }
    }

}
