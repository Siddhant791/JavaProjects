package src.Arrays;
import java.util.*;

/**
 * LeetCode 167 - Two Sum II - Input Array Is Sorted
 *
 * Problem Statement:
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Return the indices of the two numbers, index1 and index2, as an integer array [index1, index2] of length 2.
 * The tests are generated such that there is exactly one solution.
 *
 * Example:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: 2 + 7 = 9. Therefore, index1 = 1, index2 = 2.
 *
 * Constraints:
 * - 2 <= numbers.length <= 3 * 10^4
 * - -1000 <= numbers[i] <= 1000
 * - numbers is sorted in non-decreasing order
 * - -1000 <= target <= 1000
 * - The tests are generated such that there is exactly one solution
 */
public class TwoSumSortedArray {

    /**
     * Solution using HashSet and HashMap for O(n) time complexity
     *
     * Approach:
     * 1. Use HashSet to track complementary numbers (target - current)
     * 2. Use HashMap to store number-to-index mapping
     * 3. For each number, check if its complement exists in set
     *
     * Time Complexity: O(n) where n is length of array
     * - Single pass through the array
     * - HashSet and HashMap operations are O(1)
     *
     * Space Complexity: O(n)
     * - HashSet and HashMap can store up to n elements
     *
     * @param numbers Sorted input array
     * @param target Target sum to find
     * @return Array of two indices (1-based) that sum to target
     */
     public int[] twoSumUsingSpace(int[] numbers, int target) {
         int[] output = new int[2];
         Set<Integer> set = new HashSet<>();        // To store complements
         Map<Integer,Integer> map = new HashMap<>(); // To store number-index pairs

         for(int i = 0; i < numbers.length; i++){
             if (!set.contains(numbers[i])){
                 // Haven't found complement yet, add current number's complement
                 set.add(target - numbers[i]);
                 map.put(numbers[i], i + 1);  // Store 1-based index
             } else {
                 // Found complement, retrieve its index and current index
                 output[0] = map.get(target - numbers[i]);
                 output[1] = i + 1;  // 1-based index
                 return output;
             }
         }
         return output;
     }

    /**
     * Optimal solution using two pointers approach
     * Takes advantage of the sorted nature of input array
     *
     * Approach:
     * 1. Use two pointers: one from start, one from end
     * 2. If sum is too large, decrease right pointer
     * 3. If sum is too small, increase left pointer
     *
     * Time Complexity: O(n) where n is length of array
     * - Single pass through the array in worst case
     * - Each element is visited at most once
     *
     * Space Complexity: O(1)
     * - Only using two pointers regardless of input size
     *
     * @param numbers Sorted input array
     * @param target Target sum to find
     * @return Array of two indices (1-based) that sum to target
     */
    public int[] twoSumUsingTwoPointers(int[] numbers, int target) {
        int prev = 0;                    // Left pointer starts at beginning
        int last = numbers.length - 1;   // Right pointer starts at end

        while (prev < last) {
            int sum = numbers[prev] + numbers[last];
            if (sum == target){
                // Found the pair, return 1-based indices
                return new int[]{prev + 1, last + 1};
            } else if (sum > target){
                // Sum too large, decrease right pointer
                last--;
            } else {
                // Sum too small, increase left pointer
                prev++;
            }
        }

        return new int[2];  // No solution found (shouldn't happen per constraints)
    }
}
