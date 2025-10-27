package src.Arrays;

/**
 * LeetCode Problem: 1929. Concatenation of Array
 * Link: https://leetcode.com/problems/concatenation-of-array/
 *
 * Problem Description:
 * Given an integer array nums of length n, you want to create an array ans of length 2n
 * where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
 * Specifically, ans is the concatenation of two nums arrays.
 * Return the array ans.
 *
 * Technique/Pattern: Array Manipulation
 */
public class ConcatenationOfArray {
    /**
     * Given an integer array nums, return an array ans of length 2n where ans is the concatenation of two nums arrays.
     *
     * @param nums The input integer array.
     * @return The concatenated array.
     *
     * Complexity Analysis:
     * Time Complexity: O(n) - We iterate through the input array `nums` once.
     * Space Complexity: O(n) - We create a new array `out` of size `2*n` to store the result.
     */
    public int[] getConcatenation(int[] nums) {
        int n = nums.length; // Get the length of the input array. O(1)
        int[] out = new int[2 * n]; // Create a new array of double the size to store the concatenated result. O(n) space
        int j = n; // Initialize a pointer for the second half of the 'out' array. O(1)

        // Iterate through the original array 'nums'
        for (int i = 0; i < n; i++) { // Loop runs 'n' times. O(n)
            out[i] = nums[i]; // Copy the element to the first half of 'out'. O(1)
            out[j] = nums[i]; // Copy the same element to the second half of 'out'. O(1)
            j++; // Increment the pointer for the second half. O(1)
        }

        return out; // Return the concatenated array. O(1)
    }
}
