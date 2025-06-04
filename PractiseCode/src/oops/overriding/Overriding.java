package src.oops.overriding;

public class Overriding {

    public class A {
        public static void display() {
            System.out.println("Display method in class A");
        }
    }

     public class B extends A {
//        @Override
        public static void display() {
            System.out.println("Display method in class B");
        }
    }

}
