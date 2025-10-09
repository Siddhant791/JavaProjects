package src.binarySearch;

/**
 * LeetCode Link: <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">...</a>
 *
 * Problem: Find Minimum in Rotated Sorted Array
 *
 * Description:
 * Suppose an array of length n sorted in ascending order is rotated an unknown number of times.
 * For example, the array [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2].
 * Given the sorted rotated array nums, return the minimum element of this array.
 * You must write an algorithm that runs in O(log n) time.
 *
 * Technique:
 * The problem can be solved using two main approaches:
 * 1. Brute-force linear scan.
 * 2. Binary Search (optimized approach).
 */
public class FindMinimumInSortedRotatedArray {
    /**
     * Brute-force approach to find the minimum element in a rotated sorted array.
     * This method iterates through the array and finds the first element that is smaller than its predecessor.
     * If no such element is found, it means the array is not rotated or is sorted, and the first element is the minimum.
     *
     * Time Complexity: O(n)
     * In the worst case, we might iterate through the entire array (e.g., if the array is sorted and not rotated).
     *
     * Space Complexity: O(1)
     * No extra space is used beyond a few variables.
     *
     * @param nums The rotated sorted array.
     * @return The minimum element in the array.
     */
     public int findMinBruteForce(int[] nums) {
         int n = nums.length;
         if (n < 2){
             return nums[0];
         }

         // Initialize two pointers for comparison
         int i = 0;
         int j = i + 1;

         // Iterate through the array
         while(j < n){
             // If the current element (nums[j]) is smaller than the previous element (nums[i]),
             // then nums[j] is the minimum element (the pivot point).
             if (nums[i] > nums[j]){
                 return nums[j];
             }
             // Move both pointers forward
             j++;
             i++;
         }
         // If the loop completes, it means the array was not rotated (or rotated n times),
         // so the first element is the minimum.
         return nums[0];
     }

    /**
     * Optimized approach using Binary Search to find the minimum element in a rotated sorted array.
     * This method leverages the property of a rotated sorted array: the minimum element will always be
     * at the "pivot" point where the sorted order breaks.
     *
     * Time Complexity: O(log n)
     * Each iteration of the while loop halves the search space.
     *
     * Space Complexity: O(1)
     * No extra space is used beyond a few variables.
     *
     * Technique: Binary Search
     *
     * @param nums The rotated sorted array.
     * @return The minimum element in the array.
     */
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        // The loop continues as long as the left pointer is less than the right pointer.
        // When l == r, we have found the minimum element.
        while(l < r){
            // Calculate the middle index to avoid potential integer overflow (l + r) / 2.
            int m = l + (r - l)/2;

            // If nums[m] is greater than nums[r], it means the minimum element must be in the right half (m+1 to r).
            // This is because the right half is unsorted relative to nums[m], indicating the pivot is there.
            if (nums[m] > nums[r]){
                l = m + 1;
            // If nums[m] is less than or equal to nums[r], it means the minimum element is in the left half (l to m).
            // nums[m] could potentially be the minimum, so we include it in the next search range by setting r = m.
            }else{
                r = m;
            }
        }

        // When the loop terminates, l (and r) will point to the index of the minimum element.
        return nums[l];
    }
}
