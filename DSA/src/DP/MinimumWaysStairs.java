package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a solution to find the number of distinct ways to climb stairs.
 * LeetCode Problem 70: Climbing Stairs
 * Time Complexity: O(n) - Each step is calculated once and memoized
 * Space Complexity: O(n) - For memoization hashmap
 */
public class MinimumWaysStairs {

    class Solution {
        // Map to store previously calculated results for optimization
        private Map<Integer, Integer> memo = new HashMap<>();

        /**
         * Calculates the number of distinct ways to climb to the top.
         * At each step, you can either climb 1 or 2 steps.
         *
         * @param n the number of steps to climb
         * @return the number of distinct ways to reach the top
         */
        public int climbStairs(int n) {
            // Base cases
            if (n == 0) return 1;  // One way to stay at ground level (do nothing)
            if (n < 0) return 0;   // No way to climb negative stairs

            // Return memoized result if available
            if (memo.containsKey(n)) {
                return memo.get(n);
            }

            // Calculate ways by considering both 1 and 2 steps at current position
            int ways = climbStairs(n - 1) + // Ways when taking 1 step
                      climbStairs(n - 2);    // Ways when taking 2 steps
            memo.put(n, ways);    // Cache the result

            return ways;
        }
    }
}