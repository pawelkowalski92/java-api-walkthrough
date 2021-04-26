package pl.edu.utp.collections;

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
    }

}
