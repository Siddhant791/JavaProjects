package src.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LeetCode 46 - Permutations
 *
 * Problem Statement:
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Constraints:
 * - 1 <= nums.length <= 6
 * - -10 <= nums[i] <= 10
 * - All the integers of nums are unique
 */
public class Permutation {

    /**
     * Main method to generate all permutations of the input array
     * Uses backtracking approach with swapping elements
     *
     * Time Complexity: O(n!), where n is the length of input array
     * - We have n choices for first position, (n-1) for second, and so on
     * Space Complexity: O(n!) to store all permutations
     * - Additional O(n) for recursion stack depth
     *
     * @param nums Input array of distinct integers
     * @return List of all possible permutations
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        return recursion(0, output, nums);
    }

    /**
     * Recursive helper method to generate permutations using backtracking
     *
     * Approach:
     * 1. Base case: If we've placed all elements (index == length), add current permutation
     * 2. For each position from index to end:
     *    - Swap current element with element at index
     *    - Recursively generate permutations for remaining elements
     *    - Backtrack by swapping elements back
     *
     * @param index Current position we're filling in the permutation
     * @param output List to store all permutations
     * @param nums Current state of the array being permuted
     * @return Updated list of permutations
     */
    private List<List<Integer>> recursion(int index, List<List<Integer>> output, int[] nums) {
        // Base case: if we've placed all elements, add current permutation
        if (index == nums.length) {
            // Convert int[] to List<Integer> and add to output
            output.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return output;
        }

        // Try placing each remaining number at the current position
        for (int i = index; i < nums.length; i++) {
            // Make a choice - swap elements
            swap(i, index, nums);
            // Explore with this choice
            recursion(index + 1, output, nums);
            // Undo the choice (backtrack)
            swap(i, index, nums);
        }
        return output;
    }

    /**
     * Helper method to swap two elements in an array
     *
     * @param a Index of first element
     * @param b Index of second element
     * @param nums Array in which to perform the swap
     */
    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
