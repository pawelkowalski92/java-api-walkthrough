package pl.edu.utp.utils;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MeasureUtils {

    public static <T> T measureAndGet(Supplier<? extends T> supplier, Consumer<Duration> durationConsumer) {
        Instant now = Instant.now();
        try {
            return supplier.get();
        } finally {
            durationConsumer.accept(Duration.between(now, Instant.now()));
        }
    }

    public static <T> void measureAndGet(Runnable runnable, Consumer<Duration> durationConsumer) {
        Instant now = Instant.now();
        try {
            runnable.run();
        } finally {
            durationConsumer.accept(Duration.between(now, Instant.now()));
        }
    }

    public static String generateLotsOfData(int requiredSize) {
        byte[] data = new byte[requiredSize];
        Random random = new Random();
        random.nextBytes(data);
        return new String(data);
    }

    public static String generateLotsOfCharacterData(int requiredSize) {
        String testData = "testData";
        StringBuilder builder = new StringBuilder(requiredSize);
        while (builder.length() < requiredSize) {
            builder.append(testData);
        }
        return builder.toString();
    }

}
