package src.slidingwindow;

import java.util.Arrays;

public class LongestRepeatingCharacterReplacement {
    /**
     * LeetCode Problem: 424. Longest Repeating Character Replacement
     * Link: https://leetcode.com/problems/longest-repeating-character-replacement/
     *
     * Problem Description:
     * You are given a string s and an integer k. You can choose any character of the string and change it to any other
     * uppercase English character. You can perform this operation at most k times.
     * Return the length of the longest substring containing the same letter you can get after performing the above operations.
     *
     * Example 1:
     * Input: s = "ABAB", k = 2
     * Output: 4
     * Explanation: Replace the two 'A's with two 'B's or vice versa.
     *
     * Example 2:
     * Input: s = "AABABBA", k = 1
     * Output: 4
     * Explanation: Replace the one 'A' in the middle with 'B' and the string becomes "AABBBBA".
     * The longest substring with all repeating letters is "BBBB", which has a length of 4.
     *
     * Constraints:
     * 1 <= s.length <= 10^5
     * s consists of only uppercase English letters.
     * 0 <= k <= s.length
     *
     * Technique Used: Sliding Window (Two Pointers)
     *
     * Algorithm Explanation:
     * The problem can be solved using a sliding window approach. We maintain a window [L, R] and try to expand it
     * as much as possible. The condition for a valid window is that the number of characters that are *not* the
     * most frequent character within the window must be less than or equal to k.
     *
     * Let `window_length = R - L + 1`.
     * Let `maxFreq` be the count of the most frequent character in the current window.
     * The number of characters that need to be changed to make the entire window consist of `maxFreq` character is
     * `window_length - maxFreq`.
     *
     * If `window_length - maxFreq > k`, it means we have too many differing characters to change within our budget `k`.
     * In this case, the window is invalid, and we need to shrink it from the left by incrementing `L`.
     * When shrinking, we decrement the frequency of the character at `s.charAt(L)`.
     *
     * We continuously expand the window with `R` and shrink with `L` if necessary, always keeping track of the
     * maximum valid window size encountered.
     *
     * Complexity Analysis:
     * Time Complexity: O(N * 26) which simplifies to O(N), where N is the length of the string `s`.
     *   - The outer loop iterates `R` from 0 to `s.length() - 1`, making N iterations.
     *   - Inside the loop, `freq` array update is O(1).
     *   - `Arrays.stream(freq).max().getAsInt()` takes O(26) time because it iterates over a fixed-size array (26 characters).
     *   - The `while` loop for shrinking the window: `L` also traverses the string at most N times. Each operation inside
     *     the while loop is O(1).
     *   - Since `R` and `L` pointers both move forward at most N times, and the `maxFreq` calculation is O(26),
     *     the total time complexity is O(N * 26) which is effectively O(N).
     *
     * Space Complexity: O(26) which simplifies to O(1).
     *   - We use a `freq` array of size 26 to store character counts, which is constant space regardless of input string length.
     */
    public int characterReplacement(String s, int k) {
        int L = 0; // Left pointer of the sliding window
        int out = 0; // Stores the maximum length of the valid substring found so far
        int[] freq = new int[26]; // Frequency array to store counts of characters 'A' through 'Z' in the current window
        int maxFreq = 0; // Stores the maximum frequency of any character in the current window

        for (int R = 0; R < s.length(); R++) {
            // Expand the window by moving the right pointer R
            freq[(s.charAt(R) - 'A')]++; // Increment frequency of the character at R
            maxFreq = Math.max(maxFreq, freq[(s.charAt(R) - 'A')]); // Update maxFreq for the current window
            // Note: We don't need to re-calculate maxFreq from scratch (Arrays.stream(...)) every time.
            // We only need to know if the *newly added character* makes a new maxFreq.
            // The maxFreq can only increase or stay the same when R moves.
            // It might decrease when L moves, but we only care about the maxFreq in the current window for the validity check.

            // Check if the current window is invalid
            // A window is invalid if (window_length - maxFreq_in_window) > k
            // This means we need to change more than k characters to make the window consist of only the most frequent character.
            while ((R - L + 1) - maxFreq > k) {
                // Shrink the window from the left
                freq[(s.charAt(L) - 'A')]--; // Decrement frequency of the character at L
                L++; // Move the left pointer to the right
                // Note: When L moves, maxFreq might decrease, but we don't need to re-calculate it here.
                // The condition (R - L + 1) - maxFreq > k will eventually become false as L increases,
                // because (R - L + 1) decreases and maxFreq (which is based on the old window) might still be valid enough.
                // The key insight is that we are only interested in the *maximum possible length*,
                // and if a window becomes invalid, shrinking it will eventually make it valid again,
                // but the `maxFreq` we track is sufficient for the condition.
            }

            // The current window [L, R] is valid. Update the maximum length found so far.
            out = Math.max(out, R - L + 1);
        }

        return out;
    }
}
