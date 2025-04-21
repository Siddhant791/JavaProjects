import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumInputArray {
    public int[] twoSum(int[] numbers, int target) {
        int[] output = new int[2];
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if (!set.contains(numbers[i])){
                set.add(target - numbers[i]);
                map.put(numbers[i], i+1);
            }else{
                output[0] = map.get(target - numbers[i]);
                output[1] = i+1;
                return output;
            }
        }
        return output;
    }

}
