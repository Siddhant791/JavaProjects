package src;

import src.collectionframework.Maps;
import src.equalfunctionality.Dog;
import src.oops.overriding.Overriding;
import src.oops.overriding.TestOverride;
import src.pojo.C;
import src.pojo.D;
import src.pojo.Student;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main extends Dog {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // Lists section starts from here

        System.out.println("Practice Main method starts from here");
//        C.temp();
//      Static methods can be overriden concept
//        C my1 = new C();
//        D my2 = new C();
//        D my3 = new D();
//
//        my1.temp();
//        my2.temp();
//        my3.temp();

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
//        Map<String, Integer> map = new HashMap<>(){
//            {
//                put("apple", 1);
//                put("banana", 2);
//                put("orange", 3);
//            }
//        };
//        String key = "bananadsada";

//        if (map.containsKey(key)) {
//            int value = map.get(key) +1;
//            map.put(key,value);
//
//        } else {
//
//            map.put(key, 1); // If key does not exist, add it with value 1
//            System.out.println("Key does not exist in the map");
//        }
//        map.compute(key, (k, v) -> (v == null) ? 1 : v + 1);
//        map.computeIfAbsent(key, k -> 0);
//        map.put(key, map.get(key) + 1);
//
//        System.out.println(map);

//        map.computeIfAbsent(key, (s) -> s.put(s, 1)); // If key does not exist, add it with value 1

//        Integer value = map.getOrDefault(key, 0); // Returns 2 if "banana" exists, otherwise returns 0
//        if
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

//        Runnable run = () -> System.out.println("Running in a thread using Runnable interfadfdsfdsce");
//        Function<String, Integer> fn = (s) -> {
//            System.out.println("Running in a thread using Function interface with input: " + s);
//            return s.length();
//        };
//
//        Predicate<Integer> predicate = (input) -> input > 10;
//        System.out.println(predicate.test(4)); // Example usage of Predicate
//        run.run();z
//        fn.apply("Hello World");

//        ExecutorService executorService = Executors.newFixedThreadPool(3);


//        executorService.submit(() -> {
//            System.out.println("Task 1");
//            try{
//                Thread.sleep(5000);
//            }catch(Exception e){
//                e.getMessage();
//            }
//        });
//        executorService.submit(() -> {
//            System.out.println("task 2");
//            try{
//                Thread.sleep(2000);
//            }catch(Exception e){
//                e.getMessage();
//            }
//        });
//        System.out.println("Task 3 running on Main thread");

//        Callable<String> task1 = () -> {
//            System.out.println("Task 1");
//            try {
//                Thread.sleep(5000);
//            } catch (RuntimeException e) {
//                e.getMessage();
//            }
//            return "Siddhant work is done";
//        };
//
//        Callable<String> task2 = () -> {
//            System.out.println("Task 2");
//            try {
//                Thread.sleep(2000);
//            } catch (RuntimeException e) {
//                e.getMessage();
//            }
//            return "Harish work is done";
//        };

//        List<Callable<String>> tasks = new ArrayList<>();
//        tasks.add(task1);
//        tasks.add(task2);
//        List<Future<String>> futureResponse = executorService.invokeAll(tasks);
//        System.out.println(futureResponse.get(1).get());
//        System.out.println(futureResponse.get(0).get());
//        executorService.shutdown();

        // Completable future blocks of multithreading starts here

//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(2000);
//                System.out.println("Order is in progress");
//                Thread.sleep(5000);
//            } catch (RuntimeException | InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "Order is placed";
//        });
//        System.out.println("Task 1 future output is " + completableFuture.get());
//
//        System.out.println("Main task is taking more orders");
//
//        completableFuture.thenApply((next) -> {
//            try {
//                System.out.println("Dispatching process is started");
//                Thread.sleep(2000);
//            } catch (RuntimeException | InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "Order is dispatched";
//        }).join();
//        Runnable

//        List

//        System.out.println("I'm taking more orders");


        // Interfaces section starts from here

//        SimpleCalculatorInterface addition = (a,b) -> a+b;
//        SimpleCalculatorInterface square = (a,b) -> a*a;
//        addition.calculate(2,3);
//        square.calculate(2,3);

        //STring sections starts from here
//        StringLiteral MyLiteral = new StringLiteral("Hello World");
//        System.out.println(MyLiteral.getValue());

        //Streams section starts from here
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 4, 5, 7, 8);
//        StreamsClass<Integer> numbersStream = new StreamsClass<>(numbers);
//        Stream<Integer> concatenatedStream = numbersStream.concatTwoStreams(
//                Stream.of(11, 12, 13),
//                Stream.of(14, 15, 16)
//        );
//        concatenatedStream
//                .forEach(System.out::println);
//        numbers.stream();
//        List  evenNo = numbers.stream().filter(x -> x%2 == 0).distinct().toList();
//        evenNo.forEach(System.out::println);
//        List<Student> studentsLists = new ArrayList<>() {
//            {
//                add(new Student(1, "Siddhant", 90.0));
//                add(new Student(2, "Harish", 85.0));
//                add(new Student(3, "Amit", 95.0));
//                add(new Student(4, "Ravi", 80.0));
//            }
//        };
//        studentsLists.stream().filter(student -> student.getMarks() > 89).forEach(System.out::println);
//        studentsLists.stream().map(Student::getName).
//                map(String::toUpperCase).
//                forEach(System.out::println);
//        Comparator<Student> comparisonLogic = (s1, s2) -> s1.getMarks() > s2.getMarks() ?  1 :  -1;
//        Collections.sort(studentsLists, comparisonLogic);
//        Collections.sort(studentsLists, (s1, s2) -> s1.getMarks() > s2.getMarks() ?  -1 :  1);
//        System.out.println(studentsLists);
//
//        List<Student> newHello = studentsLists.stream().filter(student -> student.getName().contains("Siddhant")).toList();
//        System.out.println(newHello);

        // Method Overriding section starts from here

//        Overriding overriding = new Overriding(); // Create outer class instance
//        Overriding.A objA = overriding.new B();   // Create inner class instance
//
//        objA.display(); // Calls the overridden method in class B

//        Override over = new TestOverride();
//        Override.display(); // Calls the static method in TestOverride class

        // Tree map comparison

//        List<Student> studentsList = Arrays.asList(
//                new Student(1, "Siddhant", 90.0),
//                new Student(2, "Harish", 85.0),
//                new Student(3, "Amit", 95.0),
//                new Student(4, "Ravi", 80.0)
//        );
//
//        TreeMap<Student,Double> studentMap = new TreeMap<>(Comparator.comparing(Student::getName).thenComparing(Student::getMarks));
//        studentsList.forEach(student -> studentMap.put(student,student.getMarks()));
//        System.out.println(studentMap);

        // Practice

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6,7,8,9,10);
//        // Create a list of list one will have odd and other will have even
//
//
//
//        List<Integer> even = numbers.stream().filter(element -> element %2 == 0).toList();
//        List<Integer> odd = numbers.stream().filter(element -> element %2 != 0).toList();

//        List<Integer> list = new ArrayList<>(){
//            {
//                add(1);
//                add(2);
//                add(3);
//                add(4);
//                add(5);
//                add(6);
//                add(7);
//                add(8);
//                add(9);
//                add(10);
//            }
//        };
//
//        List<Integer> next = new ArrayList<>(list);
//        System.out.println(next);
//        list.clear();
//        System.out.println(next);


    }

    public static class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int indexEven = 0;
            int indexOdd = 1;
            int sumEven = 0;
            int sumOdd = 0;

            while (indexEven < nums.length || indexOdd < nums.length) {
                if (indexEven < nums.length) {
                    sumEven += nums[indexEven];
                }
                if (indexOdd < nums.length) {
                    sumOdd += nums[indexOdd];
                }
                indexEven += 2;
                indexOdd += 2;
            }

            return Math.max(indexEven, indexOdd);
        }

//    ArithmeticException
//    OutOfMemoryError
    }
}
