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
         Set<Integer> set = new HashSet<>();

         if (k >= nums.length){
             return normalDuplicate(nums, set);
         }

         int start = 0;

         for (int i=start; i<=k; i++){
             if (!set.add(nums[i])){
                 return true;
             }
         }

         for (int j = k+1; j<nums.length; j++){
             set.remove(nums[start]);
             start++;
             if (!set.add(nums[j])){
                 return true;
             }
         }
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
         for (int i: nums){
             if (!set.add(i)){
                 return true;
             }
         }
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
        Set<Integer> set = new HashSet<>();
        int L = 0;

        for (int R = 0 ; R< nums.length ; R++){
            if (R - L > k){
                set.remove(nums[L]);
                L++;
            }
            if (!set.add(nums[R])){
                return true;
            }
        }

        return false;
    }
}
