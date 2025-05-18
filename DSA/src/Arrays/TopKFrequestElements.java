package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #347 - Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * Problem: Given an integer array nums and an integer k, return the k most frequent elements.
 * Time Complexity: O(n log n) due to sorting
 * Space Complexity: O(n) for HashMap
 */
public class TopKFrequestElements {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            // Handle edge case when array has only one element
            if (nums.length == 1){
                return new int[] {nums[0]};
            }

            // Create HashMap to store frequency of each number
            Map<Integer, Integer> map = new HashMap<>();
            int[] output = new int[k];

            // Count frequency of each number using merge operation
            for (int n : nums){
                map.merge(n , 1, Integer::sum);
            }

            // Stream the map entries, sort by value (frequency) in descending order,
            // take top k elements, extract their keys, and convert to int array
            output = map.entrySet().stream()
                    .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                    .limit(k)
                    .map(entry -> entry.getKey())
                    .mapToInt(Integer::intValue)
                    .toArray();
            return output;
        }
    }
}
