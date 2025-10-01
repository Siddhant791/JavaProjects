package src.slidingwindow;

    /*
     * LeetCode Problem: Best Time to Buy and Sell Stock
     * Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     *
     * Description:
     * Given an array `prices` where `prices[i]` is the price of a given stock on the i-th day,
     * find the maximum profit you can achieve from one transaction (i.e., buy one and sell one share of the stock).
     * You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
     *
     * Technique/Pattern Used: Reverse Traversal, Two Pointers
     * - Traverse the array from the end to the start, maintaining the highest price seen so far (`end` pointer).
     * - For each price, calculate the potential profit if bought at current price and sold at the highest future price.
     * - Update the maximum profit accordingly.
     *
     * Time Complexity: O(n)
     * - Each element is visited once in a single loop.
     * Space Complexity: O(1)
     * - Only a few variables are used for tracking.
     */

    public class Stock {
        /**
         * Calculates the maximum profit from a single buy-sell transaction.
         * @param prices Array of stock prices.
         * @return Maximum profit achievable.
         */
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int end = n - 1; // Pointer to track the highest price from the right
            int max = 0;     // Stores the maximum profit found

            // Traverse prices from right to left
            for (int j = n - 1; j >= 0; j--) {
                // If current price is higher than the highest seen so far, update 'end'
                if (prices[j] > prices[end]) {
                    end = j;
                } else {
                    // Calculate profit if bought at current price and sold at 'end'
                    max = Math.max(prices[end] - prices[j], max);
                }
            }

            return max;
        }
    }