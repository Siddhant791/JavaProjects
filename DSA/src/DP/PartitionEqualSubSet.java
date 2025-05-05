package DP;

import java.util.Arrays;

/**
 * This class solves the Partition Equal Subset Sum problem (LeetCode 416)
 * Problem: Given an array, determine if it can be partitioned into two subsets with equal sums
 * Time Complexity: O(n*sum), where n is array length and sum is total array sum
 * Space Complexity: O(n*sum) for the DP table
 */
public class PartitionEqualSubSet {
    class Solution {
        /**
         * Determines if the array can be partitioned into two equal sum subsets
         * @param nums input array of integers
         * @return true if equal partition is possible, false otherwise
         */
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            // If sum is odd, equal partition is impossible
            if (sum % 2 != 0){
                return false;
            }

            // Target sum for each subset should be half of total sum
            int target = sum / 2;
            // DP table: rows = array indices, columns = possible sum values
            int[][] dp = new int[nums.length][target + 1];
            // Initialize with -1 to indicate unprocessed states
            for(int[] row : dp){
                Arrays.fill(row,-1);
            }

            return partition(nums, nums.length - 1, target, dp);
        }

        /**
         * Recursive helper method with memoization to find if partition is possible
         * @param nums input array
         * @param index current index being processed
         * @param target remaining target sum to achieve
         * @param dp memoization table (0=false, 1=true, -1=unprocessed)
         * @return true if partition is possible from current state
         */
        private boolean partition(int[] nums, int index, int target, int[][] dp){
            // Base case: target achieved
            if (target == 0 ){
                return true;
            }
            // Base case: first element must equal target
            if (index == 0){
                return nums[index] == target;
            }
            // Return memoized result if available
            if (dp[index][target] != -1){
                if (dp[index][target] == 0){return false;}
                else {return true;}
            }

            // Try without including current element
            boolean without = partition(nums, index - 1, target, dp);
            boolean with = false;
            // Try including current element if it doesn't exceed target
            if (nums[index] <= target){
                with = partition(nums, index - 1, target - nums[index], dp);
            }

            // Memoize result: 1 for true, 0 for false
            if (without || with) {dp[index][target] = 1;}
            else{dp[index][target] = 0;}
            return without || with;
        }
    }
}