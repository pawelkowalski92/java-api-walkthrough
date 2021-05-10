package pl.edu.utp.utils;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Supplier;

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

}
