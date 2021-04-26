package pl.edu.utp.exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CheckedExceptionsHandling {

    public static void main(String[] args) {
        Path fileToRead = Path.of(args[0]);
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(fileToRead);
            String line = reader.readLine();
            while (line != null) {
                String invertedCaseLine = invertCase(line);
                System.out.println(invertedCaseLine);
                line = reader.readLine();
            }
        } catch (IOException ex) {
            System.err.println("Cannot read file: " + fileToRead);
            ex.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    System.err.println("Cannot close reader for file: " + fileToRead);
                }
            }
        }
    }

    static String invertCase(String line) {
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (i > 10) {
                // we're simulating an error in the code
                throw new IllegalStateException("ops");
            }
            chars[i] = Character.isUpperCase(c)
                    ? Character.toLowerCase(c)
                    : Character.toUpperCase(c);
        }
        return new String(chars);
    }

}
