package src.multithreading;

import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class PythonDeveloper implements SoftwareEngineer{
    @Override
    public void startCoding(){
        System.out.println("It's started coding in python");
    }

    @Override
    public void run(){
        IntStream
                .range(0,5)
                .forEach((i) -> {
                    System.out.println(String.format("Python developer %d has started coding", i));
                    try {
                        sleep(500);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                });
    }
}
