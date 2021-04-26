package pl.edu.utp.exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CheckedExceptionsHandling {

    // overly-verbose way to read a file ;)
    public static void main(String[] args) {
        Path fileToRead = Path.of(args[0]);
        readFileOverlyVerbose(fileToRead);
        readFileInTryWithResources(fileToRead);
        readFileUsingNIO(fileToRead);
    }

    static String invertCase(String line) throws Exception {
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
//            if (i > 50) {
//                // we're simulating an error in the code
//                throw new Exception("error in inversion");
//            }
            chars[i] = Character.isUpperCase(c)
                    ? Character.toLowerCase(c)
                    : Character.toUpperCase(c);
        }
        return new String(chars);
    }

    static void readFileOverlyVerbose(Path pathToFile) {
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(pathToFile);
            String line = reader.readLine();
            while (line != null) {
                String invertedCaseLine = invertCase(line);
                System.out.println(invertedCaseLine);
                line = reader.readLine();
            }
        } catch (IOException ex) {
            System.err.println("Cannot read file: " + pathToFile);
            ex.printStackTrace();
        } catch (Exception ex) {
            System.err.println("Cannot invert case");
            ex.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    System.err.println("Cannot close reader for file: " + pathToFile);
                }
            }
        }
    }

    static void readFileInTryWithResources(Path pathToFile) {
        try (BufferedReader reader = Files.newBufferedReader(pathToFile)) {
            String line = reader.readLine();
            while (line != null) {
                String invertedCaseLine = invertCase(line);
                System.out.println(invertedCaseLine);
                line = reader.readLine();
            }
        } catch (IOException ex) {
            System.err.println("Cannot read file: " + pathToFile);
            ex.printStackTrace();
        } catch (Exception ex) {
            System.err.println("Cannot invert case");
            ex.printStackTrace();
        }
    }

    static void readFileUsingNIO(Path pathToFile) {
        try {
            String line = Files.readString(pathToFile);
            String invertedCaseLine = invertCase(line);
            System.out.println(invertedCaseLine);
        } catch (IOException ex) {
            System.err.println("Cannot read file: " + pathToFile);
            ex.printStackTrace();
        } catch (Exception ex) {
            System.err.println("Cannot invert case");
            ex.printStackTrace();
        }
    }

}
