package src.Arrays.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {
     public boolean containsNearbyDuplicateMySolution(int[] nums, int k) {
         Set<Integer> set = new HashSet<>();

         if (k >= nums.length){
             return normalDuplicate(nums, set);
         }

         int start = 0;

         for (int i=start; i<=k; i++){
             if (!set.add(nums[i])){
                 return true;
             }
         }

         for (int j = k+1; j<nums.length; j++){
             set.remove(nums[start]);
             start++;
             if (!set.add(nums[j])){
                 return true;
             }
         }
         return false;
     }

     private boolean normalDuplicate(int[] nums, Set<Integer> set){

         for (int i: nums){
             if (!set.add(i)){
                 return true;
             }
         }
         return false;

     }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int L = 0;

        for (int R = 0 ; R< nums.length ; R++){
            if (R - L > k){
                set.remove(nums[L]);
                L++;
            }
            if (!set.add(nums[R])){
                return true;
            }
        }

        return false;
    }
}
