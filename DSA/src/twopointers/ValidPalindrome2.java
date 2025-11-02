/*
 LeetCode: Valid Palindrome II
 https://leetcode.com/problems/valid-palindrome-ii/  (Problem 680)

 Problem (short): Given a non-empty string s, you may delete at most one character. Return true if you can make s a palindrome after deleting at most one character.

 Technique / Pattern used:
 - Two Pointers (left/right) with a greedy choice: when a mismatch is found, try skipping either the left or right character and verify if either choice yields a palindrome.
 - Helper check (isPalindrome) to validate the remaining substring.

 Complexity Analysis:
 - Time: O(n) — We traverse the string with two pointers. On the first mismatch we call isPalindrome which in the worst case scans the remaining characters once. Overall each character is examined O(1) times, so O(n) total.
 - Space: O(1) — only a few integer variables are used; no additional data structures proportional to n are allocated.

 Notes:
 - This implementation is greedy and relies on the problem guarantee that at most one deletion is allowed.
 - The helper method isPalindrome checks a substring [left, right] inclusively for palindrome-ness.
*/
package src.twopointers;

public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        // Initialize two pointers at the ends of the string
        int left = 0;
        int right = s.length() - 1;

        // Move pointers towards the center
        while (left < right) {
            // If characters match, move both pointers inward
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else {
                // On first mismatch, try skipping either the left or the right character.
                // If either substring is a palindrome, the answer is true (we can delete one char).
                return isPalindrome(s,left+1, right) || isPalindrome(s, left, right - 1);
            }
        }
        // If we never found a conflict (or resolved it), it's a valid palindrome
        return true;
    }

    public boolean isPalindrome(String s, int left, int right){

        // Check the substring between left and right indices (inclusive) for palindrome property
        while (left < right){
            // If a mismatch is found inside this check, substring is not a palindrome
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            // Move both pointers inward while checking
            left++;
            right--;
        }
        // No mismatches found — substring is a palindrome
        return true;
    }
}
