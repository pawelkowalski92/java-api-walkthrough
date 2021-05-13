package pl.edu.utp.bonus;

import java.io.Console;
import java.util.Scanner;

public class ReadingInputs {

    private static final Scanner STD_IN = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            clearConsole();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String name = readLine("What's your name? ");
        System.out.println("Hello, " + name + "!");
    }

    public static String readLine(String prompt) {
        try {
            return readFromConsole(prompt);
        } catch (IllegalStateException ex) {
            // JVM console doesn't work, fall back to std::in
            return readFromStdIn(prompt);
        }
    }

    public static String readFromConsole(String prompt) {
        Console console = System.console();
        if (console == null) {
            throw new IllegalStateException("Console is unavailable");
        }
        return console.readLine(prompt);
    }

    public static String readFromStdIn(String prompt) {
        System.out.print(prompt);
        // instead of creating scanner each time, we can create one static instance to save some CPU cycles
        return STD_IN.nextLine();
    }

    public static void clearConsole() throws Exception {
        boolean isWindows = System.getProperty("os.name").startsWith("Windows");
        String command = isWindows ? "cls" : "clear";
        int exitCode = new ProcessBuilder(command)
                .inheritIO()
                .start()
                .waitFor();
        if (exitCode != 0) {
            throw new IllegalStateException("Cannot clear console");
        }
    }

}
