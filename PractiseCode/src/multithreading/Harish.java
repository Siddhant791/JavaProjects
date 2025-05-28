package src.multithreading;

import java.util.stream.IntStream;

public class Harish extends Thread{

    @Override
    public void run(){
        IntStream
                .range(0,5)
                        .forEach(i -> {
                            System.out.println("Harish is working for " + i + " times");
                            try {
                                sleep(500);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        });

    }
}
