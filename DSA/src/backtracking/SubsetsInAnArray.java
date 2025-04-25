package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution to generate all possible subsets of a given array using backtracking.
 * LeetCode Problem 78: Subsets
 * Time Complexity: O(2^n) where n is the length of the input array
 * Space Complexity: O(n) for the recursion stack
 */
public class SubsetsInAnArray {

    /**
     * Inner class containing the solution for generating subsets.
     */
    class Solution {
        /**
         * Generates all possible subsets of the given array.
         * For example, for input [1,2], the output will be: [[], [1], [2], [1,2]]
         *
         * @param nums The input array of integers
         * @return List containing all possible subsets
         */
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> output = new ArrayList<>();  // Stores all generated subsets
            List<Integer> subset = new ArrayList<>();        // Stores current subset being built
            dfs(nums, 0, subset, output);                   // Start DFS from index 0
            return output;
        }

        /**
         * Recursive helper method that uses depth-first search to generate subsets.
         * For each element, we have two choices:
         * 1. Include the current element in the subset
         * 2. Exclude the current element from the subset
         *
         * @param nums The input array of integers
         * @param i Current index being processed
         * @param subset Current subset being built
         * @param output List storing all generated subsets
         */
        private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> output) {
            if (i >= nums.length) {                         // Base case: reached end of array
                output.add(new ArrayList<>(subset));        // Add copy of current subset to output
                return;
            }

            subset.add(nums[i]);                           // Include current element
            dfs(nums, i + 1, subset, output);              // Recurse with next index
            subset.remove(subset.size() - 1);              // Backtrack by removing current element
            dfs(nums, i + 1, subset, output);              // Recurse without current element
        }
    }
}