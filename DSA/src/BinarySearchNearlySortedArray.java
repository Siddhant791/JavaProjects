public class BinarySearchNearlySortedArray {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        // int m = (l+r)/2;

        while(l<r){
            int m = (l+r)/2;

            if(nums[m] > nums[r]){
                l = m + 1;
            }else{
                r = m;
            }
        }

        int pivot = l;

        int result = binarySearch(nums, target, 0, pivot - 1);

        if(result != -1){
            return result;
        }
        return binarySearch(nums,target,pivot,nums.length -1);
    }

    private int binarySearch(int[] nums, int target, int l, int r){
        while(l<=r){
            int m = l + (r - l)/2;
            if (target == nums[m]) return m;
            if (target>=nums[m]){
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return -1;
    }


}
