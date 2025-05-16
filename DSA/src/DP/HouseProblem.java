package DP;

/**
 * This class contains a solution to the "House Robber Problem".
 * The problem involves finding the maximum amount of money that can be robbed
 * from houses arranged in a line, with the constraint that adjacent houses cannot be robbed.
 */
public class HouseProblem {
    class Solution {
        /**
         * Solves the House Robber Problem using dynamic programming.
         *
         * @param nums An array where each element represents the amount of money in a house.
         * @return The maximum amount of money that can be robbed without alerting the police.
         */
        public int rob(int[] nums) {
            int n = nums.length;

            // Base case: If there are no houses, return 0.
            if (n == 0) {
                return 0;
            }

            // Base case: If there is only one house, return the money in that house.
            if (n == 1) {
                return nums[0];
            }

            // Initialize variables to store the maximum money robbed up to the previous two houses.
            int rob1 = nums[0]; // Maximum money robbed from the first house.
            int rob2 = Math.max(nums[0], nums[1]); // Maximum money robbed from the first two houses.

            // Iterate through the rest of the houses.
            for (int i = 2; i < n; i++) {
                // Temporarily store the current maximum (rob2).
                int temp = rob2;

                // Update rob2 to the maximum of rob2 (not robbing the current house)
                // or rob1 + nums[i] (robbing the current house).
                rob2 = Math.max(rob2, nums[i] + rob1);

                // Update rob1 to the previous maximum (temp).
                rob1 = temp;
            }

            // Return the maximum money that can be robbed.
            return rob2;
        }
    }
}