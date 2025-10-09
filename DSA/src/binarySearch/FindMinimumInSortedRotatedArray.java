package src.binarySearch;

public class FindMinimumInSortedRotatedArray {
     public int findMinBruteForce(int[] nums) {
         int n = nums.length;
         if (n < 2){
             return nums[0];
         }

         int i = 0;
         int j = i + 1;

         while(j < n){
             if (nums[i] > nums[j]){
                 return nums[j];
             }
             j++;
             i++;
         }
         return nums[0];
     }

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while(l < r){
            int m = l + (r - l)/2;
            if (nums[m] > nums[r]){
                l = m + 1;
            }else{
                r = m;
            }
        }

        return nums[l];
    }
}
