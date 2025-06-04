package src;

import src.collectionframework.Maps;
import src.equalfunctionality.Dog;
import src.interfaces.Override;
import src.oops.overriding.Overriding;
import src.oops.overriding.TestOverride;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;


public class Main extends Dog {
    public static void main(String[] args) throws InterruptedException {

        // Lists section starts from here

//        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
//        Stream<Integer> streamList = list.stream();
//
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        Thread.sleep(500);
//        list.add(null);
//        System.out.println(list);

//        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.add("D");
//
//        for (String item : list) {
//            list.remove("A"); // Throws ConcurrentModificationException
//        }


//        List<Integer> mutableList = new ArrayList<>(list); // Mutable list
//        List<Integer> immutableList = List.copyOf(list); // Immutable list


//        System.out.println("Hello World");
//        Map<String, Integer> map = new HashMap<>();
//        map.merge("apple", 1, Integer::sum); // Inserts "apple" = 1
//        map.merge("apple", 1, Integer::sum); // Updates "apple" = 2
//        map.merge("banana", 1, Integer::sum); // Updates "apple" = 2
//        map.merge("apple", 1, Integer::sum); // Updates "apple" = 2
//        map.merge("banana", 1, Integer::sum); // Updates "apple" = 2
//
//        System.out.println(map);

        // Maps section starts from here

//        Maps map = new Maps();
//        map.printAllElementsInMap();
//        map.groupBy();
//        Map<Integer, String> evenMap = map.filterMapIfKeyIsOdd();
//        evenMap
//                .entrySet()
//                .stream()
//                .forEach(System.out::println);

//        map.map.put(null,"Null Value gsdfgdsf");
//        System.out.println(map.map.get(null)); // This will print "Null Value"

        // Multithreading section starts from here

//        Harish t1 = new Harish();
//        Siddhant t2 = new Siddhant();
//
//        t1.start();
//        t2.start();


//        JavaDeveloper javaDev = new JavaDeveloper("Siddhant");
//        SoftwareEngineer pythonDev = new PythonDeveloper();
//
//        javaDev.startCoding();
//        System.out.println(javaDev.nameOfDeveloper());
//        pythonDev.startCoding();
//
//        SoftwareEngineer javaScriptDev = () -> System.out.println("Started coding in javascript");
//        javaScriptDev.startCoding();

//        Thread javaDeveloperThread = new Thread(javaDev);
//        Thread pythonDeveloper = new Thread(pythonDev);
//        SoftwareEngineerThread javaScript = () -> System.out.println("It's Java script engineer");
//        Thread javaScriptDeveloperThread = new Thread(javaScript);
//        javaDeveloperThread.start();
//        pythonDeveloper.start();
//        javaScriptDeveloperThread.start();

        // Interfaces section starts from here

//        SimpleCalculatorInterface addition = (a,b) -> a+b;
//        SimpleCalculatorInterface square = (a,b) -> a*a;
//        addition.calculate(2,3);
//        square.calculate(2,3);

        //STring sections starts from here
//        StringLiteral MyLiteral = new StringLiteral("Hello World");
//        System.out.println(MyLiteral.getValue());

        //Streams section starts from here
//        List<Integer> numbers = Arrays.asList(1 , 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        StreamsClass<Integer> numbersStream = new StreamsClass<>(numbers);
//        Stream<Integer> concatenatedStream = numbersStream.concatTwoStreams(
//                Stream.of(11, 12, 13),
//                Stream.of(14, 15, 16)
//        );
//        concatenatedStream
//                .forEach(System.out::println);


        // Method Overriding section starts from here

//        Overriding overriding = new Overriding(); // Create outer class instance
//        Overriding.A objA = overriding.new B();   // Create inner class instance
//
//        objA.display(); // Calls the overridden method in class B

//        Override over = new TestOverride();
//        Override.display(); // Calls the static method in TestOverride class

    }

    public static class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1){
                return nums[0];
            }
            int indexEven = 0;
            int indexOdd = 1;
            int sumEven = 0;
            int sumOdd = 0;

            while(indexEven < nums.length || indexOdd < nums.length){
                if (indexEven < nums.length ) {
                    sumEven+=nums[indexEven];
                }
                if (indexOdd < nums.length ) {
                    sumOdd+=nums[indexOdd];
                }
                indexEven+=2;
                indexOdd+=2;
            }

            return Math.max(indexEven,indexOdd);
        }
    }

}
