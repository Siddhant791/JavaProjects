package src.DP;

/*
 LeetCode: https://leetcode.com/problems/palindromic-substrings/
 Problem: Count Palindromic Substrings (LeetCode 647)
 Technique / Pattern: Expand Around Center (two pointers)
 Description:
  - For every index i in the string, treat i as the center of an odd-length palindrome
    and the gap between i and i+1 as the center of an even-length palindrome.
  - Expand left and right pointers while characters match to count all palindromic substrings
    centered at that position.
 Complexity:
  - Time: O(n^2) in the worst case (for each of the n centers we may expand up to n steps).
  - Space: O(1) additional space (only counters and pointer variables).
*/

public class PalindromicSubstrings {
    // Counts total palindromic substrings in s using expand-around-center approach.
    public int countSubstrings(String s) {
        int out = 0; // total palindrome count

        // iterate through each index, treating it as the center
        for (int i = 0; i < s.length(); i++){
            int L = i;
            int R = i;

            // Expand for odd-length palindromes (center at i)
            // While pointers are within bounds and characters at L and R match,
            // we've found a palindrome substring.
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
                out++;    // count this palindrome
                L--;      // expand left
                R++;      // expand right
            }

            // Reset pointers to check even-length palindromes (center between i and i+1)
            L = i;
            R = i + 1;

            // Expand for even-length palindromes (center between i and i+1)
            // Same logic: if characters match, it's a palindrome; expand further.
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
                out++;    // count this palindrome
                L--;      // expand left
                R++;      // expand right
            }
        }
        return out; // final count of palindromic substrings
    }
}