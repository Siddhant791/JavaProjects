package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    static class Solution {

        // This solution is nlogn time complexity which is not best solution but intermediate one
        public int longestConsecutive(int[] nums) {
            int lengthOfArray = nums.length ;
            if (lengthOfArray == 0){
                return 0;
            }
            if (lengthOfArray == 1){
                return 1;
            }

            Arrays.sort(nums);

            int output = 0;
            int prev = 0;
            int current = 1;

            while(current < lengthOfArray){
                int tempCounter = 1;
                int previousElement = nums[prev];
                int currentElement = nums[current];

                while((((previousElement + 1) == currentElement) || (previousElement == currentElement)) && (current < lengthOfArray) ){
                    if (previousElement != currentElement)
                    {
                        tempCounter++;
                    }
                    prev++;
                    current++;
                    if (current < lengthOfArray){
                        previousElement = nums[prev];
                        currentElement = nums[current];
                    }
                }
                output = Math.max(tempCounter, output);
                prev++;
                current++;
            }

            return output;
        }

        // Effiencient O(n) solution using HashSet

        public int longestConsecutiveEfficient(int[] nums) {
            int lengthOfArray = nums.length ;
            if (lengthOfArray == 0){
                return 0;
            }
            if (lengthOfArray == 1){
                return 1;
            }

            Set<Integer> set = new HashSet<>();
            int output = 0;

            for (int i: nums){
                set.add(i);
            }

            for (int element : set){
                if (set.contains(element - 1)){
                    continue;
                }
                // int temp = element;
                int tempCounter = 1;
                while (set.contains(element + tempCounter)){
                    tempCounter++;
                }

                output = Math.max(tempCounter, output);
            }

            return output;
        }
    }
}
