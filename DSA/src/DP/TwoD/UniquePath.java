package src.DP.TwoD;

/**
 * LeetCode Link: <a href="https://leetcode.com/problems/unique-paths/">Unique Paths</a>
 *
 * <h2>Problem Description</h2>
 * A robot is located at the top-left corner of an `m x n` grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 *
 * <h2>Solution Approach - Dynamic Programming (Memoization)</h2>
 * This problem can be solved using Dynamic Programming, specifically with a top-down (memoization) approach.
 * The core idea is that to reach a cell `(r, c)`, the robot must have come from either `(r-1, c)` (moving down)
 * or `(r, c-1)` (moving right). Therefore, the number of unique paths to `(r, c)` is the sum of unique paths
 * to `(r-1, c)` and unique paths to `(r, c-1)`.
 *
 * <h3>Technique/Pattern:</h3>
 * Dynamic Programming (Memoization), Grid DP
 *
 * <h3>Time Complexity:</h3>
 * O(m * n) - Each cell `(r, c)` in the `m x n` grid is visited and computed at most once.
 *
 * <h3>Space Complexity:</h3>
 * O(m * n) - For the `dp` table used to store computed results. Additionally, O(m * n) in the worst case
 * for the recursion stack depth.
 */
public class UniquePath {
    /**
     * Calculates the number of unique paths from the top-left corner to the bottom-right corner
     * of an m x n grid.
     *
     * @param m The number of rows in the grid.
     * @param n The number of columns in the grid.
     * @return The total number of unique paths.
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return helper(m-1,n-1,dp);
    }

    /**
     * Recursive helper function with memoization to calculate unique paths.
     *
     * @param m The current row index (0-indexed, target is m-1).
     * @param n The current column index (0-indexed, target is n-1).
     * @param dp The 2D array used for memoization, storing already computed unique paths.
     * @return The number of unique paths to reach cell (m, n).
     */
    public int helper(int m, int n, int[][] dp){
        if (m == 0 && n == 0){
            return 1; // Base case: If we are at the starting cell (0,0), there's 1 way to reach it.
        } else if (m < 0 || n < 0){
            return 0; // Base case: If we go out of bounds, there are 0 ways.
        } else if (dp[m][n] != 0){
            return dp[m][n]; // If the result for this cell is already computed, return it.
        } else {
            // Recursive step: The number of paths to (m, n) is the sum of paths from (m-1, n) and (m, n-1).
            dp[m][n] = helper(m - 1, n, dp) + helper(m, n - 1, dp);
            return dp[m][n];
        }
    }
}
