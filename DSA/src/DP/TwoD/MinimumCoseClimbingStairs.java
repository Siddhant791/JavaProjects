package src.DP.TwoD;

import java.util.Arrays;

public class MinimumCoseClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);

        return Math.min(dfs(0,cost,dp), dfs(1,cost,dp));
    }

    public int dfs(int i, int[] cost, int[] dp){
        int n = cost.length;
        if (i >= n ){
            return 0;
        }

        if (dp[i] != -1){
            return dp[i];
        }

        int first = dfs(i+1, cost,dp);
        int second = dfs(i+2, cost,dp);

        dp[i] = cost[i] + Math.min(first,second);
        return dp[i];
    }
}
