package src.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class maximumTotalDamage {
    public long maximumTotalDamage(int[] power) {

        if (power.length == 1){
            return power[0];
        }

        Map<Integer,Long> map = new HashMap<>();

        // Counting frequency of the characters
        for(int i:power){
            map.merge(i,1L,Long::sum);
        }

        // Removing duplicates
        int[] values = new int[map.size()];
        int idx = 0;
        for(Integer key: map.keySet()){
            values[idx++] = key;
        }

        // Sorting array so that we don't need to worry about power -1 and power - 2 conditions
        Arrays.sort(values);

        long[] dp = new long[values.length];
        Arrays.fill(dp,-1L);

        long[] total = new long[values.length];

        // Collecting the frequenncy some if any element is picked up
        // Since if a element is picked up then it's all iccurances must be picket up to maximize the sum
        for(int i=0; i < values.length;i++) total[i] = values[i] * map.get(values[i]);

        return dfs(0, values, total, dp);

    }

    public long dfs(int i, int[] originalArray, long[] total, long[] dp){
        int n = originalArray.length;
        if (i >= n){
            return 0L;
        }

        // Memo check
        if (dp[i] != -1){
            return dp[i];
        }

        // Skip current element and check
        long skip = dfs(i + 1, originalArray, total, dp);

        // Find the next valid element if we choose existing one
        int nextValidElementIdx = valid(i + 1, n - 1, originalArray, originalArray[i] + 2);

        // Consider the current element and then do the dfs for remaining array from next valid index
        long withoutSkip = total[i] + (nextValidElementIdx == -1? 0L : dfs(nextValidElementIdx, originalArray, total, dp));

        // Calculate the maxium from both side and return
        dp[i] = Math.max(skip, withoutSkip);
        return dp[i];
    }

    // Binary Search
    public int valid(int start, int end, int[] array, int target){

        int ans = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if (array[mid] > target){
                // it's could be the next valid element
                // Hence we'll skip the right side array of this element
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
}
