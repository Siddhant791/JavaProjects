/*
 LeetCode: Majority Element
 https://leetcode.com/problems/majority-element/

 Problem (short): Given an integer array of size n, return the majority element — the element that appears more than n/2 times.
 You may assume the array is non-empty and the majority element always exists (as per the LeetCode prompt).

 Techniques / Patterns used:
 - Hash Map counting (frequency map) for a straightforward frequency-based solution.
 - Boyer–Moore Voting Algorithm for a space-optimized candidate-selection approach.

 Complexity Analysis:
 1) majorityElement (HashMap approach)
    - Time: O(n) — we iterate the array once and update counts in the map.
    - Space: O(n) — in the worst case (all distinct except the majority) the map stores O(n) keys.

 2) majorityElementSpaceOptimized (Boyer–Moore Voting Algorithm)
    - Time: O(n) — single pass to determine the candidate.
    - Space: O(1) — only a couple of integer variables are used.

 Notes:
 - The HashMap approach returns as soon as a count exceeds n/2 (early exit).
 - The Boyer–Moore approach finds the candidate that would be the majority when one exists; since the problem guarantees existence, no separate verification pass is necessary here.
*/
package src.Arrays;

import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        // HashMap to store frequency counts for each distinct value in nums
        HashMap<Integer,Integer> map = new HashMap<>();
        // majority threshold: strictly greater than n/2
        int max = nums.length / 2;
        for(int i : nums){
            // increment the count for value `i` (map.merge will insert 1 if absent)
            map.merge(i, 1, Integer::sum);
            // if any element's count exceeds the majority threshold, return it immediately
            if (map.get(i) > max){
                return i; // early return — this is the majority element
            }
        }

        // As per problem constraints, there will always be a majority element.
        // This return is defensive; if input violated constraints, 0 would be returned.
        return 0;
    }

    public int majorityElementSpaceOptimized(int[] nums) {
        // Using Boyer-Moore Voting Algorithm
        int result = 0, count = 0;

        for (int i:nums){
            // When count drops to 0, pick the current element as a new candidate
            if (count == 0){
                result = i; // candidate assignment
            }

            // If current element matches candidate, increment count; otherwise decrement.
            if (i == result){
                count++; // support for candidate
            }else{
                count--; // opposition reduces support
            }
        }
        // The candidate stored in `result` is the majority element (given the problem guarantee).
        return result;
    }
}
