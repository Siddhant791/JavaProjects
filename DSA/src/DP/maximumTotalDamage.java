package src.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode: <a href="https://leetcode.com/problems/maximum-total-damage-with-spell-casting/">2801. Maximum Total Damage With Spell Casting</a>
 *
 * This problem can be solved using Dynamic Programming with memoization.
 * The core idea is to sort the unique power values and then decide for each power value
 * whether to include it (and all its occurrences) or skip it.
 *
 * Technique: Dynamic Programming, Memoization, Binary Search, Sorting.
 *
 */

public class maximumTotalDamage {
    public long maximumTotalDamage(int[] power) {

        if (power.length == 1){
            return power[0];
        }

        Map<Integer,Long> map = new HashMap<>();

        // Counting frequency of each power value.
        // This helps in calculating the total damage if a particular power value is chosen.
        // Time Complexity: O(N), where N is the length of the power array.
        // Space Complexity: O(U), where U is the number of unique power values.
        for(int i:power){
            map.merge(i,1L,Long::sum);
        }

        // Extracting unique power values into an array.
        // This array will be sorted to facilitate DP transitions.
        // Time Complexity: O(U)
        int[] values = new int[map.size()];
        int idx = 0;
        for(Integer key: map.keySet()){
            values[idx++] = key;
        }

        // Sorting the unique power values.
        // This is crucial for the DP approach, allowing us to easily find valid next elements.
        // Time Complexity: O(U log U)
        Arrays.sort(values);

        long[] dp = new long[values.length];
        Arrays.fill(dp,-1L);

        long[] total = new long[values.length];

        // Pre-calculating the total damage for each unique power value if it were to be picked.
        // If a power 'p' is chosen, all occurrences of 'p' must be picked to maximize damage.
        // Time Complexity: O(U)
        for(int i=0; i < values.length;i++) total[i] = values[i] * map.get(values[i]);

        // Start the DFS (Dynamic Programming with memoization) from the first unique power value.
        // The result will be the maximum total damage.
        return dfs(0, values, total, dp);

    }

    /**
     * Recursive DFS function with memoization to calculate the maximum total damage.
     */

    public long dfs(int i, int[] originalArray, long[] total, long[] dp){
        int n = originalArray.length;
        if (i >= n){
            return 0L;
        }

        // Memoization check: if this subproblem has already been solved, return the stored result.
        // This prevents redundant calculations.
        if (dp[i] != -1){
            return dp[i];
        }

        // Option 1: Skip the current element (originalArray[i]).
        // In this case, we move to the next element (i + 1) and recursively calculate the maximum damage.
        long skip = dfs(i + 1, originalArray, total, dp);

        // Option 2: Consider the current element (originalArray[i]).
        // If we choose originalArray[i], we cannot choose elements with power originalArray[i] - 1
        // or originalArray[i] + 1.
        // We need to find the next valid element to consider. This is done using binary search.
        // The target for binary search is originalArray[i] + 2, as any element with power less than or equal to
        // originalArray[i] + 1 would be invalid.
        // Time Complexity for valid(): O(log U)
        int nextValidElementIdx = valid(i + 1, n - 1, originalArray, originalArray[i] + 2);

        // Calculate the damage if we choose the current element.
        // This includes the total damage from originalArray[i] (total[i]) plus the maximum damage
        // from the remaining valid elements starting from nextValidElementIdx.
        long withoutSkip = total[i] + (nextValidElementIdx == -1? 0L : dfs(nextValidElementIdx, originalArray, total, dp));

        // Store the maximum of the two options (skip or consider) in the DP table.
        // This is the result for the current subproblem.
        dp[i] = Math.max(skip, withoutSkip);
        return dp[i];
    }

    /**
     * Binary search function to find the index of the first element in 'array' that is strictly greater than 'target'.
     * This is used to find the next valid element after choosing 'originalArray[i]'.
     *
     * Time Complexity: O(log N), where N is the length of the 'array' (or U, the number of unique elements).
     */
    public int valid(int start, int end, int[] array, int target){

        int ans = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if (array[mid] > target){
                // If array[mid] is greater than target, it could be a valid next element.
                // We store this as a potential answer and try to find an even smaller valid element on the left.
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
}
