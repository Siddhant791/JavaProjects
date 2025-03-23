import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class DuplicateElements {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length == 0){
            return false;
        }
        // Set<Integer> set = new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     if(set.contains(nums[i])){
        //         return true;
        //     }
        //     set.add(nums[i]);
        // }
        // return false;

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return !(set.size() == nums.length);
    }
}
