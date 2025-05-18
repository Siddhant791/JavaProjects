package src;

import src.equalfunctionality.Dog;

import java.util.HashMap;
import java.util.Map;


public class Main extends Dog {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Map<String, Integer> map = new HashMap<>();
        map.merge("apple", 1, Integer::sum); // Inserts "apple" = 1
        map.merge("apple", 1, Integer::sum); // Updates "apple" = 2
        map.merge("banana", 1, Integer::sum); // Updates "apple" = 2
        map.merge("apple", 1, Integer::sum); // Updates "apple" = 2
        map.merge("banana", 1, Integer::sum); // Updates "apple" = 2

        System.out.println(map);

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
