package src.DP;

import java.util.Arrays;

/**
 * LeetCode 213 - House Robber II
 *
 * Problem Statement:
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount
 * of money stashed. All houses are arranged in a circle. That means the first house is the neighbor
 * of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically
 * contact the police if two adjacent houses were broken into on the same night.
 *
 * Example:
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent.
 *
 * Technique Used:
 * - Dynamic Programming (State Machine)
 * - Array manipulation
 * - The problem is solved by considering two scenarios:
 *   1. Rob houses from index 0 to n-2 (excluding last house)
 *   2. Rob houses from index 1 to n-1 (excluding first house)
 */
public class HouseRobber2 {
    /**
     * Main method to solve House Robber II problem
     *
     * Algorithm:
     * 1. Handle circular constraint by splitting into two linear problems:
     *    - One excluding the last house
     *    - One excluding the first house
     * 2. Use helper function to solve each linear problem
     * 3. Return maximum of the two results
     *
     * Time Complexity: O(n) where n is the number of houses
     * Space Complexity: O(n) for the array copies
     *
     * @param nums Array representing money in each house
     * @return Maximum amount that can be robbed
     */
    public int rob(int[] nums) {
        // Handle special case of single house
        if (nums.length == 1) return nums[0];

        // Create two arrays excluding first and last house respectively
        int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);

        // Return maximum of two scenarios
        return Math.max(helperFunction(nums1), helperFunction(nums2));
    }

    /**
     * Helper method to solve linear House Robber problem
     * Uses Dynamic Programming with constant space optimization
     *
     * State Transition:
     * rob2 = max(rob2, rob1 + current house value)
     * where rob1 and rob2 represent max money at previous positions
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums Array representing money in each house
     * @return Maximum amount that can be robbed
     */
    public int helperFunction(int[] nums){
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // Initialize two variables to track maximum money
        // rob1 represents max money if we rob current house
        // rob2 represents max money if we don't rob current house
        int rob1 = nums[0];
        int rob2 = Math.max(nums[0], nums[1]);

        // Iterate through remaining houses
        for(int i = 2; i < nums.length; i++){
            int temp = rob2;
            // Either rob current house + money from house before previous
            // Or skip current house and keep previous maximum
            rob2 = Math.max(rob2, rob1 + nums[i]);
            rob1 = temp;
        }

        return rob2;
    }
}
