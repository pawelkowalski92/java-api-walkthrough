package pl.edu.utp.io;

import pl.edu.utp.utils.MeasureUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NIOExample {

    public static void main(String[] args) {
        String lotsOfData = MeasureUtils.generateLotsOfCharacterData(500 * 1024 * 1024);
        MeasureUtils.measureAndGet(() -> safeSaveDataToFile("lotsOfData.txt", lotsOfData),
                duration -> System.out.println("Saving a lot of data took: " + duration));

        String readLotsOfData = MeasureUtils.measureAndGet(() -> readFromFile("lotsOfData.txt"),
                duration -> System.out.println("Reading a lot of data took: " + duration));

        String readLotsOfDataNIO = MeasureUtils.measureAndGet(() -> readFromFileNIO("lotsOfData.txt"),
                duration -> System.out.println("Reading a lot of data using NIO took: " + duration));

        System.out.println("Data is the same? " + Objects.equals(lotsOfData, readLotsOfData));
        System.out.println("NIO data is the same? " + Objects.equals(readLotsOfData, readLotsOfDataNIO));
    }

    public static void safeSaveDataToFile(String fileName, String data) {
        try {
            Files.writeString(Path.of(fileName), data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try (Reader reader = new BufferedReader(new FileReader(file))) {
            for (int read = reader.read(); read > 0; read = reader.read()) {
                builder.append((char) read);
            }
            return builder.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String readFromFileNIO(String fileName) {
        Path path = Path.of(fileName);
        try (Stream<String> lines = Files.lines(path)) {
            return lines.collect(Collectors.joining());
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
