package src.Arrays;
import java.util.*;

/**
 * LeetCode 15 - 3Sum
 *
 * Problem Statement:
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * - nums[0] + nums[2] + nums[4] = (-1) + 1 + (-1) = -1
 * - nums[1] + nums[2] + nums[3] = 0 + 1 + 2 = 3
 *
 * Constraints:
 * - 3 <= nums.length <= 3000
 * - -105 <= nums[i] <= 105
 */
public class ThreeSum {
    /**
     * Finds all unique triplets in the array that sum to zero
     *
     * Approach:
     * 1. Sort the array first (allows us to avoid duplicates and use two pointers)
     * 2. Fix one element and use two pointers (left and right) for the remaining sum
     * 3. Skip duplicate values to avoid duplicate triplets
     * 4. Move pointers based on sum comparison with 0
     *
     * Time Complexity: O(n²) where n is the length of array
     * - Sorting takes O(nlogn)
     * - For each element, we use two pointers: O(n)
     * - Overall: O(nlogn) + O(n²) = O(n²)
     *
     * Space Complexity: O(1) or O(n) depending on sorting implementation
     * - We only use constant extra space for pointers
     * - Output space is not counted in space complexity
     *
     * @param nums Input array to find triplets from
     * @return List of lists containing all unique triplets that sum to zero
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  // Sort array to handle duplicates and use two pointers
        List<List<Integer>> out = new ArrayList<>();

        for(int i = 0; i < nums.length ; i++){
            if (nums[i] > 0) break;  // If current number is positive, no solution possible
            // Skip duplicates for i to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;            // Left pointer
            int r = nums.length - 1;  // Right pointer

            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0){
                    // Found a triplet, add to result
                    out.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                    // Skip duplicates for l
                    while( l < r && nums[l] == nums[l-1]){
                        l++;
                    }
                }else if (sum > 0){
                    r--;  // Sum too large, decrease right pointer
                }else{
                    l++;  // Sum too small, increase left pointer
                }
            }
        }
        return out;
    }
}
