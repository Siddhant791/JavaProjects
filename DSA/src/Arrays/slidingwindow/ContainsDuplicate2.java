package src.Arrays.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 219 - Contains Duplicate II
 *
 * Problem Statement:
 * Given an integer array nums and an integer k, return true if there are two distinct indices
 * i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 *
 * Example:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Explanation: nums[3] == nums[0] and |3 - 0| <= 3
 *
 * Pattern Used: Sliding Window with HashSet
 * - Fixed-size sliding window of size k+1
 * - HashSet to track elements in current window
 * - Window slides by removing leftmost element and adding new element
 *
 * Approach 1 (First Solution):
 * 1. Handle edge case where k >= array length
 * 2. Fill initial window of size k+1
 * 3. Slide window by removing start element and adding new element
 *
 * Time Complexity: O(n) where n is length of array
 * Space Complexity: O(min(k, n)) - HashSet stores at most k+1 elements
 */
public class ContainsDuplicate2 {
     /**
      * First approach using explicit window initialization
      *
      * Time Complexity: O(n)
      * - One pass through the array
      * - HashSet operations are O(1)
      *
      * Space Complexity: O(min(k, n))
      * - HashSet stores at most k+1 elements
      *
      * @param nums Input array
      * @param k Maximum allowed distance between duplicates
      * @return true if duplicates exist within distance k
      */
     public boolean containsNearbyDuplicateMySolution(int[] nums, int k) {
         // HashSet to store the elements in current window
         Set<Integer> set = new HashSet<>();

         // Edge case: if k >= array length, we can check entire array at once
         if (k >= nums.length){
             return normalDuplicate(nums, set);
         }

         // Start index for sliding window
         int start = 0;

         // Initialize first window of size k+1
         for (int i=start; i<=k; i++){
             // If we can't add element, it means duplicate found in window
             if (!set.add(nums[i])){
                 return true;
             }
         }

         // Slide window through rest of array
         for (int j = k+1; j<nums.length; j++){
             // Remove leftmost element from window
             set.remove(nums[start]);
             // Move window start point right
             start++;
             // Try to add new element, return true if it's already in set
             if (!set.add(nums[j])){
                 return true;
             }
         }
         // No duplicates found within distance k
         return false;
     }

     /**
      * Helper method to handle case when k >= array length
      * Simple duplicate check without distance constraint
      *
      * Time Complexity: O(n)
      * Space Complexity: O(n)
      */
     private boolean normalDuplicate(int[] nums, Set<Integer> set){
         // Simple linear scan for duplicates without distance constraint
         for (int i: nums){
             // If element already exists in set, we found a duplicate
             if (!set.add(i)){
                 return true;
             }
         }
         // No duplicates found
         return false;
     }

    /**
     * Optimized approach using single loop
     * More elegant implementation of sliding window pattern
     *
     * Pattern Benefits:
     * - Combines window initialization and sliding in single loop
     * - More concise and easier to understand
     * - Same time and space complexity as first approach
     *
     * Time Complexity: O(n)
     * Space Complexity: O(min(k, n))
     *
     * @param nums Input array
     * @param k Maximum allowed distance between duplicates
     * @return true if duplicates exist within distance k
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // HashSet to maintain current window elements
        Set<Integer> set = new HashSet<>();
        // Left pointer of window
        int L = 0;

        // Right pointer moves through array, expanding window
        for (int R = 0 ; R < nums.length ; R++){
            // If window size exceeds k, remove leftmost element and shrink window
            if (R - L > k){
                set.remove(nums[L]);    // Remove element at left pointer
                L++;                    // Move left pointer right
            }
            // Try to add current element, return true if it's already in window
            if (!set.add(nums[R])){
                return true;    // Found duplicate within distance k
            }
        }
        // No duplicates found within distance k
        return false;
    }
}
