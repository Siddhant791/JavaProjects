package src.DP.TwoD;

import java.util.Arrays;

public class MinimumCoseClimbingStairs {
    /**
     * LeetCode Problem: 746. Min Cost Climbing Stairs
     * https://leetcode.com/problems/min-cost-climbing-stairs/
     *
     * This problem asks us to find the minimum cost to reach the top of the floor.
     * We are given an integer array `cost` where `cost[i]` is the cost of `i`-th step.
     * Once we pay the cost, we can either take one step or two steps.
     * We can start from either step 0 or step 1.
     *
     * Technique: Dynamic Programming (Memoization / Top-Down DP)
     *
     * The problem can be broken down into smaller overlapping subproblems.
     * The minimum cost to reach the top from step `i` depends on the minimum cost
     * to reach the top from step `i+1` and step `i+2`.
     *
     * Time Complexity: O(N), where N is the number of steps. Each state `dp[i]` is computed once.
     * Space Complexity: O(N) for the `dp` array and O(N) for the recursion stack in the worst case.
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);

        return Math.min(dfs(0,cost,dp), dfs(1,cost,dp));
    }

    /**
     * Depth-First Search (DFS) with Memoization to calculate the minimum cost.
     * This function calculates the minimum cost to reach the top of the stairs
     * starting from the current step `i`.
     *
     * @param i The current step index.
     * @param cost The array of costs for each step.
     * @param dp The memoization array to store computed minimum costs for subproblems.
     * @return The minimum cost to reach the top starting from step `i`.
     *
     * Time Complexity: O(1) for each call after the first computation due to memoization.
     * Space Complexity: O(N) for the recursion stack in the worst case (if not memoized, it would be O(2^N)).
     */
    public int dfs(int i, int[] cost, int[] dp){
        int n = cost.length; // total number of steps
        if (i >= n ){ // reached or passed the top -> no additional cost
            return 0;
        }

        if (dp[i] != -1){ // if already computed, return cached result
            return dp[i];
        }

        int first = dfs(i+1, cost,dp); // cost starting from next step (take 1 step)
        int second = dfs(i+2, cost,dp); // cost starting from next+1 step (take 2 steps)

        dp[i] = cost[i] + Math.min(first,second); // current cost plus cheaper of the two options
        return dp[i]; // return and memoize result
    }

    /**
     * LeetCode Problem: 746. Min Cost Climbing Stairs
     * https://leetcode.com/problems/min-cost-climbing-stairs/
     *
     * Technique: Dynamic Programming — Bottom-up, In-place Space Optimization.
     *
     * Description:
     * - This method performs a bottom-up DP by updating the `cost` array in-place.
     * - For each index `i` from `cost.length - 3` down to `0`, it sets
     *   `cost[i] = cost[i] + min(cost[i+1], cost[i+2])`, representing the minimum
     *   cost to reach the top starting from step `i`.
     * - The final answer is `min(cost[0], cost[1])` because we may start at step 0 or 1.
     *
     * Time Complexity: O(N) — single pass through the array.
     * Space Complexity: O(1) extra space — modifies input array in-place.
     *
     * Note: This mutates the input `cost` array. If the original array must be kept,
     * make a copy before calling this method.
     */
    public int minCostClimbingStairsMostOptimized(int[] cost){
        for (int i = cost.length - 3 ; i>=0; i--){
            cost[i] += Math.min(cost[i+1], cost[i+2]);
        }
        return Math.min(cost[0], cost[1]);
    }
}
