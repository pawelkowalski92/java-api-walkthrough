package pl.edu.utp.exceptions;

public class ExceptionsHandling {

    public static void main(String[] args) {
        System.out.println(readSafelyFromString("10"));
        System.out.println(readSafelyFromString("50.3"));
        System.out.println(readSafelyFromString("ala ma kota"));
        System.out.println(readSafelyFromString("40"));
    }

    // example of checked exception: NumberFormatException
    public static int readFromString(String input) {
        return Integer.parseInt(input);
    }

    // catching the exception - different types
    public static int readSafelyFromString(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return readFallback(input);
        } catch (IllegalArgumentException ex) {
            return -5;
        }/* multicatch */
        catch (IllegalStateException | UnsupportedOperationException ex) {
            return 10;
        }/* catch (IOException ex) { // it's checked exception that wasn't declared; compiler doesn't allow to pollute the code

        }*/ finally {
            System.out.println("Input parsed");
        }
    }

    /*
    catching the exception by generic type (polimorphism)
    public static int readSafelyFromString(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception ex) {
            return readFallback(input);
        }
    }
     */

    // define explicit fallback method
    public static int readFallback(String input) {
        try {
            return (int) Double.parseDouble(input);
        } catch (NumberFormatException ex) {
            System.err.println("Unexpected input: " + input);
            return -1;
        }
    }

}
