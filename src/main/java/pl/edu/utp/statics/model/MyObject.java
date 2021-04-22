package pl.edu.utp.statics.model;

public class MyObject {

    public static final String DESCRIPTION = "My little object";

    private static int counter = 0;

    private String name;

    public static int getCounter() {
        return counter;
    }

    /*
    non-static structures cannot be accessed in static context!
    public static String getName() {
        return name;
    }
    */

    public MyObject(String name) {
        this.name = name;
        counter++;
    }

}
