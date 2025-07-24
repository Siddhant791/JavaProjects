package src.DP;

/**
 * LeetCode Problem 5: Longest Palindromic Substring
 * 
 * Given a string s, return the longest palindromic substring in s.
 * 
 * Technique/Pattern Used: Expand Around Center
 * - For each character (and each pair of consecutive characters), expand outwards to find the longest palindrome centered there.
 * - This is an efficient way to check all possible palindromic substrings.
 * 
 * Time Complexity: O(n^2)
 * - For each character, expanding around the center takes O(n) time in the worst case.
 * - There are O(n) centers (2n-1 in total for odd and even length palindromes).
 * 
 * Space Complexity: O(1)
 * - Only a constant amount of extra space is used.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int lengthOfTheInputString = s.length();
        if ( lengthOfTheInputString < 2){
            return s;
        }

        String result = "";
        int resultLength = 0;

        // Iterate over each character in the string as a potential center
        for (int i = 0; i < lengthOfTheInputString ; i++ ){
            // Odd length palindrome: expand around single character center
            int left = i;
            int right = i;

            // Expand while the substring is a palindrome
            // Time Complexity per expansion: O(1), total O(n) per center
            while (left >= 0 && right < lengthOfTheInputString && s.charAt(left) == s.charAt(right)){
                if ( (right - left + 1) > resultLength){
                    result = s.substring(left, right + 1);
                    resultLength = result.length();
                }
                left--;
                right++;
            }

            // Even length palindrome: expand around consecutive character centers
            left = i;
            right = i + 1;

            // Expand while the substring is a palindrome
            // Time Complexity per expansion: O(1), total O(n) per center
            while (left >= 0 && right < lengthOfTheInputString && s.charAt(left) == s.charAt(right)){
                if ( (right - left + 1) > resultLength){
                    result = s.substring(left, right + 1);
                    resultLength = result.length();
                }
                left--;
                right++;
            }
        }

        return result;
    }
}
