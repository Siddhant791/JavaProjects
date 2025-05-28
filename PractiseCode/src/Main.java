package src;

import src.collectionframework.Maps;
import src.equalfunctionality.Dog;
import src.multithreading.Harish;
import src.multithreading.Siddhant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main extends Dog {
    public static void main(String[] args) {
//        System.out.println("Hello World");
//        Map<String, Integer> map = new HashMap<>();
//        map.merge("apple", 1, Integer::sum); // Inserts "apple" = 1
//        map.merge("apple", 1, Integer::sum); // Updates "apple" = 2
//        map.merge("banana", 1, Integer::sum); // Updates "apple" = 2
//        map.merge("apple", 1, Integer::sum); // Updates "apple" = 2
//        map.merge("banana", 1, Integer::sum); // Updates "apple" = 2
//
//        System.out.println(map);

        Maps map = new Maps();
//        map.printAllElementsInMap();
        map.groupBy();
//        Map<Integer, String> evenMap = map.filterMapIfKeyIsOdd();
//        evenMap
//                .entrySet()
//                .stream()
//                .forEach(System.out::println);

        Harish t1 = new Harish();
        Siddhant t2 = new Siddhant();

        t1.start();
        t2.start();

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
