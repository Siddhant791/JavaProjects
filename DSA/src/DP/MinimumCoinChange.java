package DP;

import java.util.HashMap;
import java.util.Map;

public class MinimumCoinChange {

    // Inner class to encapsulate the solution logic
    class Solution {

        // Memoization map to store the minimum coins required for a given amount
        Map<Integer, Integer> dp = new HashMap<>();

        /**
         * Public method to calculate the minimum number of coins required to make up the given amount.
         * If it's not possible to make up the amount, returns -1.
         *
         * @param coins Array of coin denominations
         * @param amount The target amount
         * @return Minimum number of coins required, or -1 if not possible
         */
        public int coinChange(int[] coins, int amount) {
            // Call the recursive helper function
            int output = coinChangeRecursive(coins, amount);
            // If the result is Integer.MAX_VALUE, it means no solution was found
            return output == Integer.MAX_VALUE ? -1 : output;
        }

        /**
         * Recursive helper function to calculate the minimum number of coins required for a given amount.
         * Uses memoization to avoid redundant calculations.
         *
         * @param coins Array of coin denominations
         * @param amount The target amount
         * @return Minimum number of coins required, or Integer.MAX_VALUE if not possible
         */
        private int coinChangeRecursive(int[] coins, int amount) {
            // Base case: If the amount is 0, no coins are needed
            if (amount == 0) {
                return 0;
            }
            // Base case: If the amount is negative, return -1 (invalid case)
            if (amount < 0) {
                return -1;
            }
            // Check if the result for this amount is already computed
            if (dp.containsKey(amount)) {
                return dp.get(amount);
            }

            // Initialize the minimum coins required to a very large value
            int minimum = Integer.MAX_VALUE;

            // Iterate through each coin denomination
            for (int coin : coins) {
                // Recursively calculate the result for the remaining amount
                int output = coinChange(coins, amount - coin) + 1;

                // If the result is 0 (invalid case), reset it to Integer.MAX_VALUE
                if (output == 0) {
                    output = Integer.MAX_VALUE;
                }

                // Update the minimum coins required
                minimum = Math.min(output, minimum);
            }

            // Store the result in the memoization map
            dp.put(amount, minimum);

            // Return the minimum coins required for the current amount
            return minimum;
        }
    }
}