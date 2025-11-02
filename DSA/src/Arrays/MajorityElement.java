package src.Arrays;

import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = nums.length / 2;
        for(int i : nums){
            map.merge(i, 1, Integer::sum);
            if (map.get(i) > max){
                return i;
            }
        }

        return 0;
    }
}
