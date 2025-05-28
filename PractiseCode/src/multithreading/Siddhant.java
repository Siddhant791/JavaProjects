package src.multithreading;

import java.util.stream.IntStream;

public class Siddhant  extends Thread{
    @Override
    public void run(){
        IntStream
                .range(0,5)
                        .forEach(i -> {
                            System.out.println(String.format("Siddhant is working for %d",i));
                            try{
                                sleep(1000);
                            }catch(InterruptedException e){
                                throw new RuntimeException(e);
                            }
                        });
    }
}
