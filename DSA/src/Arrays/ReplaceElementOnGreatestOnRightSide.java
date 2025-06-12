package src.Arrays;

/**
 * LeetCode 1299 - Replace Elements with Greatest Element on Right Side
 *
 * Problem Statement:
 * Given an array arr, replace every element in that array with the greatest
 * element among the elements to its right, and replace the last element with -1.
 * After doing so, return the array.
 *
 * Example:
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 * Explanation:
 * - index 0 --> the greatest element to the right of index 0 is index 1 (18).
 * - index 1 --> the greatest element to the right of index 1 is index 4 (6).
 * - index 2 --> the greatest element to the right of index 2 is index 4 (6).
 * - index 3 --> the greatest element to the right of index 3 is index 4 (6).
 * - index 4 --> the greatest element to the right of index 4 is index 5 (1).
 * - index 5 --> there are no elements to the right of index 5, so we put -1.
 *
 * Constraints:
 * - 1 <= arr.length <= 10^4
 * - 1 <= arr[i] <= 10^5
 */
public class ReplaceElementOnGreatestOnRightSide {
    /**
     * Replaces each element with the greatest element on its right side
     *
     * Approach:
     * We traverse from right to left, keeping track of the maximum element seen so far.
     * For each position:
     * 1. Save current element in temp (we'll need it to update max)
     * 2. Replace current element with the current maximum
     * 3. Update maximum by comparing previous max with the element we saved
     *
     * Time Complexity: O(n) where n is the length of array
     * - We make a single pass through the array from right to left
     * - Each element is processed exactly once
     *
     * Space Complexity: O(1)
     * - We only use two extra variables (max and temp)
     * - We modify the array in-place
     *
     * @param arr Input array to be modified
     * @return Modified array with each element replaced by greatest on right
     */
    public int[] replaceElements(int[] arr) {
        int max = -1;           // Initialize max as -1 (for rightmost element)
        int temp = 0;          // To store current element while we replace it
        for(int j = arr.length - 1; j >=0 ; j--){
            temp = arr[j];      // Store current element
            arr[j] = max;       // Replace with maximum seen so far
            max = Math.max(temp, max);  // Update maximum
        }
        return arr;
    }
}
