package binarySearch;

/**
 * Solution for LeetCode 74: Search a 2D Matrix
 * Problem: Write an efficient algorithm that searches for a value target in an m x n matrix.
 * The matrix has the following properties:
 * - Integers in each row are sorted from left to right
 * - The first integer of each row is greater than the last integer of the previous row
 * Time Complexity: O(m * log n) where m is number of rows and n is number of columns
 * Space Complexity: O(1)
 */
public class BinarySearchIn2dArray {
    class Solution {
        /**
         * Searches for target value in sorted 2D matrix using row-wise binary search
         * @param matrix input 2D matrix with sorted rows
         * @param target value to search for
         * @return true if target is found, false otherwise
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            // Iterate through each row of the matrix
            for (int[] row: matrix){
                // Perform binary search on current row
                boolean output = helper(row, target);
                // If target found in current row, return true
                if (output) {return true;}
            }
            // Target not found in any row
            return false;
        }

        /**
         * Helper method to perform binary search on a sorted array
         * @param nums sorted array to search in
         * @param target value to search for
         * @return true if target is found, false otherwise
         */
        private boolean helper(int[] nums, int target){
            // Initialize left and right pointers for binary search
            int left = 0;
            int right = nums.length - 1;

            // Continue search while search space is valid
            while(left <= right){
                // Calculate middle index (avoiding potential overflow)
                int mid = left + (right - left) / 2;

                if(nums[mid] == target){
                    return true;    // Target found
                }else if(nums[mid] < target){
                    left = mid + 1; // Search in right half
                }else{
                    right = mid - 1;// Search in left half
                }
            }
            // Target not found in array
            return false;
        }
    }
}