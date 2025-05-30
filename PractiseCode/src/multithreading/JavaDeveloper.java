package src.multithreading;

import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class JavaDeveloper implements SoftwareEngineer, Runnable{

    private String name;

    public JavaDeveloper(String name){
        name = name.toUpperCase();
        this.name = name;
    }
    @Override
    public void startCoding(){
        System.out.println("It's coding in java");
    }

    public String nameOfDeveloper(){
        return name;
    }

    public void changeName(String name){
        this.name = name;
    }

    @Override
    public void run(){
        IntStream
                .range(0,5)
                        .forEach( (i) -> {
                            System.out.println(String.format("Java developer %d has started coding",i));
                            try{
                                sleep(1000);
                            }catch (InterruptedException e){
                                throw new RuntimeException(e);
                            }
                        });
//        System.out.println("Java developer is working");
    }

}
