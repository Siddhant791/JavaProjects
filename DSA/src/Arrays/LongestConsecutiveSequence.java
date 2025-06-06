package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 128 - Longest Consecutive Sequence
 *
 * Problem Statement:
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 *
 * Example:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Constraints:
 * - 0 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 */
public class LongestConsecutiveSequence {

    static class Solution {

        /**
         * First Approach: Sorting based solution
         *
         * Approach:
         * 1. Sort the array first
         * 2. Use two pointers to track previous and current elements
         * 3. Count consecutive numbers while traversing the sorted array
         *
         * Time Complexity: O(nlogn) due to sorting
         * Space Complexity: O(1) as we only use constant extra space
         *
         * @param nums Input array of integers
         * @return Length of longest consecutive sequence
         */
        public int longestConsecutive(int[] nums) {
            // Handle edge cases
            int lengthOfArray = nums.length;
            if (lengthOfArray == 0) return 0;
            if (lengthOfArray == 1) return 1;

            // Sort the array first
            Arrays.sort(nums);

            int output = 0;
            int prev = 0;          // Pointer to previous element
            int current = 1;       // Pointer to current element

            while(current < lengthOfArray) {
                int tempCounter = 1;   // Counter for current consecutive sequence
                int previousElement = nums[prev];
                int currentElement = nums[current];

                // Check for consecutive elements or duplicates
                while((((previousElement + 1) == currentElement) || (previousElement == currentElement))
                      && (current < lengthOfArray)) {
                    // Only increment counter for consecutive elements, not duplicates
                    if (previousElement != currentElement) {
                        tempCounter++;
                    }
                    prev++;
                    current++;
                    if (current < lengthOfArray) {
                        previousElement = nums[prev];
                        currentElement = nums[current];
                    }
                }
                // Update maximum length found so far
                output = Math.max(tempCounter, output);
                prev++;
                current++;
            }

            return output;
        }

        /**
         * Second Approach: HashSet based optimal solution
         *
         * Approach:
         * 1. Add all numbers to HashSet for O(1) lookups
         * 2. For each number, if it's the start of a sequence (no number-1 exists),
         *    count consecutive numbers until sequence breaks
         * 3. Keep track of maximum sequence length
         *
         * Time Complexity: O(n) as we traverse the array twice at most
         * Space Complexity: O(n) to store numbers in HashSet
         *
         * @param nums Input array of integers
         * @return Length of longest consecutive sequence
         */
        public int longestConsecutiveEfficient(int[] nums) {
            // Handle edge cases
            int lengthOfArray = nums.length;
            if (lengthOfArray == 0) return 0;
            if (lengthOfArray == 1) return 1;

            // Store all numbers in HashSet for O(1) lookup
            Set<Integer> set = new HashSet<>();
            int output = 0;
            for (int i: nums) {
                set.add(i);
            }

            // Check each number if it's the start of a sequence
            for (int element : set) {
                // Skip if this number is not the start of a sequence
                if (set.contains(element - 1)) {
                    continue;
                }

                int tempCounter = 1;
                // Count consecutive numbers starting from current element
                while (set.contains(element + tempCounter)) {
                    tempCounter++;
                }
                // Update maximum sequence length
                output = Math.max(tempCounter, output);
            }

            return output;
        }
    }
}
