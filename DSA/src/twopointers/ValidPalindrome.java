package src.twopointers;

public class ValidPalindrome {
    // LeetCode Problem: Reorder List
    // Link: https://leetcode.com/problems/reorder-list/
    // Technique/Pattern: Linked List Manipulation, Two Pointers, Fast and Slow Pointer, Reverse Linked List
    //
    // Problem Statement:
    // Given the head of a singly linked list, reorder the list as follows:
    // L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...
    // You may not modify the values in the list's nodes, only nodes themselves may be changed.
    //
    // Approach:
    // 1. Find the middle of the linked list using the fast and slow pointer technique. (Time: O(n), Space: O(1))
    // 2. Reverse the second half of the list. (Time: O(n), Space: O(1))
    // 3. Merge the two halves by alternating nodes. (Time: O(n), Space: O(1))
    //
    // Overall Complexity:
    // Time: O(n)
    // Space: O(1)
    public boolean isPalindrome(String s) {
        s = s.toLowerCase(); // Convert string to lowercase for case-insensitive comparison
        int start = 0, end = s.length() - 1; // Initialize two pointers

        while (start < end){
            char first = s.charAt(start); // Get character at start pointer
            char last = s.charAt(end);    // Get character at end pointer
            // Skip non-alphanumeric characters
            if (!Character.isLetterOrDigit(first) ||  !Character.isLetterOrDigit(last)){
                if(!Character.isLetterOrDigit(first)){
                    start++; // Move start pointer forward if not alphanumeric
                }else{
                    end--;   // Move end pointer backward if not alphanumeric
                }
                continue;    // Continue to next iteration
            }

            if (first != last){
                return false; // Characters do not match, not a palindrome
            }
            start++; // Move start pointer forward
            end--;   // Move end pointer backward
        }
        return true; // All characters matched, is a palindrome
    }
}
