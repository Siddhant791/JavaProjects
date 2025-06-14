package src.Arrays;

/**
 * LeetCode 795 - Number of Subarrays with Bounded Maximum
 *
 * Problem Statement:
 * Given an integer array nums and two integers left and right, return the number
 * of contiguous non-empty subarrays such that the value of the maximum array element
 * in that subarray is in the range [left, right].
 *
 * Example:
 * Input: nums = [2,1,4,3], left = 2, right = 3
 * Output: 3
 * Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3]
 *
 * Pattern Used: Two Pointers Variant
 * - Uses two pointers (start and end) to track valid subarray boundaries
 * - Similar to sliding window but with different update logic
 *
 * Algorithm Approach:
 * 1. Use two pointers to maintain the boundaries of valid subarrays:
 *    - start: marks the last position where we found element > right
 *    - end: marks the last position where we found element >= left
 * 2. For each position i:
 *    - If nums[i] > right: reset both pointers
 *    - If nums[i] >= left: update end pointer
 *    - Add number of valid subarrays ending at current position
 *
 * Time Complexity: O(n) where n is the length of nums array
 * - Single pass through the array
 * - Each element is processed exactly once
 *
 * Space Complexity: O(1)
 * - Only using two pointers (start and end)
 * - No extra space needed regardless of input size
 *
 * Key Insight:
 * The number of valid subarrays ending at current position is (end - start),
 * which represents all possible subarrays that:
 * - End at the current position
 * - Have maximum element in range [left, right]
 */
public class SubArrayMaximumBounded {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            int start = -1;    // Last position where nums[i] > right
            int end = -1;      // Last position where nums[i] >= left
            int output = 0;    // Count of valid subarrays

            for(int i=0; i< nums.length; i++){
                if (nums[i] > right){
                    start = end = i;    // Reset both pointers
                    continue;
                }

                if (nums[i] >= left){
                    end = i;            // Update end pointer for valid element
                }
                output+= end - start;   // Add count of valid subarrays ending at i
            }

            return output;
        }
}
