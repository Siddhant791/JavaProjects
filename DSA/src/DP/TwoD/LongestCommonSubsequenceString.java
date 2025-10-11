package src.DP.TwoD;

/**
 * LeetCode Link: <a href="https://leetcode.com/problems/longest-common-subsequence/">Longest Common Subsequence</a>
 *
 * The problem asks us to find the length of the longest common subsequence between two given strings, `text1` and `text2`.
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing
 * the order of the remaining elements.
 *
 * This problem can be solved using Dynamic Programming (DP) with Memoization.
 *
 * Technique: Dynamic Programming (Memoization)
 *
 * Time Complexity: O(N*M), where N is the length of `text1` and M is the length of `text2`.
 * This is because each state `(n, m)` in the `memo` table is computed once.
 *
 * Space Complexity: O(N*M) for the `memo` table, and O(N+M) in the worst case for the recursion stack.
 *
 */
public class LongestCommonSubsequenceString {
    /**
     * Main function to calculate the length of the longest common subsequence.
     * Initializes the memoization table and calls the helper function.
     *
     * @param text1 The first string.
     * @param text2 The second string.
     * @return The length of the longest common subsequence.
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] memo = new int[n][m];

        // Instantiating the dp array with -1
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m;j++){
                memo[i][j] = -1;
            }
        }

        return helper(text1, text2, 0, 0, memo);
    }

    /**
     * Helper function to compute the longest common subsequence using recursion with memoization.
     *
     * @param str1 The first string.
     * @param str2 The second string.
     * @param n The current index in str1.
     * @param m The current index in str2.
     * @param memo The memoization table to store computed results. `memo[i][j]` stores the LCS length
     *             for substrings `str1[i...]` and `str2[j...]`.
     * @return The length of the longest common subsequence for the current substrings.
     */
    public int helper(String str1, String str2, int n, int m, int[][] memo){
        // Base condition: if either string is exhausted, no common subsequence can be formed.
        if (str1.length() == n || str2.length() == m){
            return 0;
        }

        // If the result for this subproblem is already computed, return it from memo.
        if(memo[n][m] != -1){
            return memo[n][m];
        }

        // If characters match, increment count and move to the next characters in both strings.
        if (str1.charAt(n) == str2.charAt(m)){
            memo[n][m] = 1 + helper(str1, str2, n+1, m+1, memo);
        } else { // If characters don't match, consider two possibilities:
            // 1. Skip character in str1 and find LCS of remaining str1 and current str2.
            // 2. Skip character in str2 and find LCS of current str1 and remaining str2.
            // Take the maximum of these two possibilities.
            memo[n][m] = Math.max(helper(str1,str2, n+1, m, memo), helper(str1,str2, n, m+1, memo));
        }

        return memo[n][m];
    }
}
