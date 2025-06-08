import static java.lang.Thread.sleep;

public class ShortMain {
    public static void main(String[] args) {
        System.out.println("In Main method");
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 is running");
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();


        Employee e1 = new Employee("Suraj");
        Employee e2 = new Employee("Sid");

        Thread t2 = new Thread(e1);
        Thread t3 = new Thread(e2);

        t2.start();
        t3.start();

        System.out.println("In the end of main method");

    }


    static class Employee implements Runnable {
        // Employee class implementation
        private String name;

        public Employee(String name){
            this.name = name;
        }

        private void methodToBeRanAsThread(){
            System.out.println("Employee " + this.name + " has started working");
        }

        @Override
        public void run() {
            methodToBeRanAsThread();
        }
    }
}
