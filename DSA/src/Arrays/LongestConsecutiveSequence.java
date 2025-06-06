package Arrays;

import java.util.Arrays;

public class LongestConsecutiveSequence {

    class Solution {

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
    }
}
