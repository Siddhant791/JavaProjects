package src.binarySearch;

/**
 * https://leetcode.com/problems/binary-search/ LeetCode Problem: 704. Binary Search
 * LeetCode Problem: 704. Binary Search
 *
 * Given a sorted (in ascending order) integer array nums of n elements and a target value,
 * write a function to search for target in nums. If target exists, then return its index,
 * otherwise return -1.
 *
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 * Constraints:
 * You may assume that all elements in nums are unique.
 * n will be in the range [1, 10000].
 * The value of each element in nums will be in the range [-9999, 9999].
 *
 * Technique/Pattern: Binary Search
 */
public class BinarySearchInSortedArray {

    /**
     * Performs a binary search on a sorted array to find the target element.
     *
     * Time Complexity: O(log N), where N is the number of elements in the array.
     * This is because in each step, the search space is halved.
     *
     * Space Complexity: O(1), as only a few extra variables are used regardless of the input size.
     *
     * @param nums The sorted array of integers to search within.
     * @param target The integer value to search for.
     * @return The index of the target if found, otherwise -1.
     */
    public int search(int[] nums, int target) { // Function to perform binary search
        int start = 0; // Initialize the starting index of the search range
        int end = nums.length - 1; // Initialize the ending index of the search range

        while (start <= end) { // Continue searching while the start index is less than or equal to the end index
            // Calculate the middle index. Using `(start + end) / 2` can lead to integer overflow
            // if `start` and `end` are very large. A safer way is `start + (end - start) / 2`.
            int mid = start + (end - start) / 2; // Calculate the middle index to divide the search range

            if (nums[mid] == target) { // If the middle element is the target, we found it
                return mid; // Return the index of the target
            } else if (nums[mid] > target) { // If the middle element is greater than the target
                // The target must be in the left half of the current search space.
                // We exclude `mid` because we already checked it.
                end = mid - 1; // Adjust the end to search in the left half
            } else { // If the middle element is less than the target
                // The target must be in the right half of the current search space.
                // We exclude `mid` because we already checked it.
                start = mid + 1; // Adjust the start to search in the right half
            }
        }

        return -1; // If the target is not found after the loop, return -1

    }
}
