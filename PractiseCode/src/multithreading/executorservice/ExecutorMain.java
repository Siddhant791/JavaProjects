package src.multithreading.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Executor main method");
        long curr = System.currentTimeMillis();
        int b = 5;
        int a = 10;
        Callable<Integer> add = () -> {
            Thread.sleep(5000);
            return a+b;
        };
        Callable<Integer> subtract = () -> {
            Thread.sleep(5000);
            return a-b;
        };
        ExecutorService es = Executors.newFixedThreadPool(1);
        es.submit(add);
        es.submit(subtract);


        System.out.println(System.currentTimeMillis() - curr);

        es.shutdown();

    }
}
