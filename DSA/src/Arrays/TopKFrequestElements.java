package Arrays;

import java.util.HashMap;
import java.util.Map;

public class TopKFrequestElements {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            if (nums.length == 1){
                return new int[] {nums[0]};
            }

            Map<Integer, Integer> map = new HashMap<>();
            int[] output = new int[k];

            for (int n : nums){
                map.merge(n , 1, Integer::sum);
            }

            output = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                    .limit(k).map(entry -> entry.getKey()).mapToInt(Integer::intValue).toArray();
            return output;

        }
    }
}
