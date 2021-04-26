package pl.edu.utp.bonus;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class MultiThreads {

    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread().getName() + " is working");

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " (child thread) is working");
            }
        });
        a.setName("a");
        a.start();

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " (child thread) is working");
            }
        });
        b.setName("b");
        b.start();

        Future<Integer> myIntPromise = simulatePromise();
        System.out.println("After promise simulation");

        Integer myInt = myIntPromise.get();
        System.out.println(myInt);

        CompletableFuture<Integer> myBetterIntPromise = betterSimulatePromise();
        myInt = myBetterIntPromise.get();
        System.out.println(myInt);

        System.out.println(Thread.currentThread().getName() + " is shutting down");
    }

    // never do that; reuse executor if possible, don't create new each time for single invocation
    public static Future<Integer> simulatePromise() {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Future<Integer> myIntPromise = exec.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                return 5;
            }

        });
        exec.shutdown();
        return myIntPromise;
    }

    // more functional, more promise-like
    public static CompletableFuture<Integer> betterSimulatePromise() {
        return CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 5;
            }
        }).thenApply(integer -> integer * 2);
    }

}
