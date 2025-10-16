package multithreading;

import java.util.concurrent.*;

public class MultithreadingMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("In Multithreading main class");
        callablePractice();
    }

    // Make two tasks using callable and submit using executor service and print response
    public static void callablePractice() {
        Callable<String> task1 = () -> {
            Thread.sleep(1000);
            int x = 5/0;
            return "Task 1";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(3000);
            return "Task 2";
        };

        ExecutorService es = Executors.newFixedThreadPool(3);

        try {

            Future<String> f1 = es.submit(task1);
            Future<String> f2 = es.submit(task2);

            System.out.println("Tasks are submitted");

            System.out.println(f1.get());
            System.out.println(f2.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            es.shutdown();
        }

    }
}
