package binarySearch;

public class BinarySearch2dArrayOptimized {
    class Solution {
        /**
         * Searches for a target value in a sorted 2D matrix using binary search
         * Time Complexity: O(log(n*m)) where n and m are matrix dimensions
         * Space Complexity: O(1)
         *
         * @param matrix sorted 2D array where each row and column is in ascending order
         * @param target value to search for
         * @return true if target exists in matrix, false otherwise
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            // Get matrix dimensions
            int n = matrix.length;    // number of rows
            int m = matrix[0].length; // number of columns

            // Treat 2D matrix as a flattened sorted array of size n*m
            int left = 0;            // start index
            int right = n * m - 1;   // end index

            while (left <= right) {
                int mid = (left + right) / 2;
                // Convert 1D index to 2D coordinates:
                // row = mid/m, column = mid%m
                if (matrix[mid / m][mid % m] == target) {
                    return true;  // target found
                } else if (matrix[mid / m][mid % m] < target) {
                    left = mid + 1;   // search right half
                } else {
                    right = mid - 1;  // search left half
                }
            }
            return false;  // target not found
        }
    }
}
