package src.Arrays;

// LeetCode: https://leetcode.com/search/?q=score%20of%20string
// Problem: Compute the total "score" of a string defined as the sum of absolute differences
//          between ASCII values of adjacent characters.
// Technique/Pattern: Single-pass iteration over adjacent elements (adjacent-difference).
// Complexity:
//   - Time: O(n) where n = s.length() (to convert to char[] and to iterate once).
//   - Space: O(1) extra space (output and loop index). Converting to char[] uses O(n) input storage.
public class ScoreOfAString {
    public int scoreOfString(String s) {
        // Convert to char array for fast indexed access (O(n) time, O(n) input storage).
        char[] input = s.toCharArray();
        // Accumulator for the total score.
        int output = 0;
        // Iterate over adjacent pairs only; stop at length - 1 to avoid OOB access.
        for (int i = 0; i < input.length - 1; i++) {
            // Compute absolute difference between adjacent characters.
            // Note: `char` values are implicitly cast to `int` when subtracted.
            output += Math.abs(input[i] - input[i + 1]);
        }
        // Return the accumulated score.
        return output;
    }
}
