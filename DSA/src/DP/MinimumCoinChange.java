package DP;

import java.util.HashMap;
import java.util.Map;

public class MinimumCoinChange {

    class Solution {

        Map<Integer, Integer> dp = new HashMap<>();

        public int coinChange(int[] coins, int amount) {
            int output = coinChangeRecursive(coins, amount);
            return output == Integer.MAX_VALUE ? -1 : output;
        }

        private int coinChangeRecursive(int[] coins, int amount){
            if (amount == 0){
                return 0;
            }
            if (amount < 0){
                return -1;
            }
            if (dp.containsKey(amount)){
                return dp.get(amount);
            }

            int minimum = Integer.MAX_VALUE;

            for(int coin : coins){
                int output = coinChange(coins, amount - coin) + 1;
                if (output == 0){
                    output = Integer.MAX_VALUE;
                }
                minimum = Math.min(output, minimum);
            }

            dp.put(amount, minimum);

            return minimum;
        }
    }
}
