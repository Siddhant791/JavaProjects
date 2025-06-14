package src.Arrays;

public class SubArrayMaximumBounded {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            int start = -1;
            int end = -1;

            int output = 0;

            for(int i=0; i< nums.length; i++){
                if (nums[i] > right){
                    start = end = i;
                    continue;
                }

                if (nums[i] >= left){
                    end = i;
                }
                output+= end - start;
            }

            return output;
        }
}
