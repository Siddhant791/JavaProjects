package src.Arrays;

public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] out = new int[2*n];
        int j = n;
        for (int i = 0; i<n ;i++){
            out[i] = nums[i];
            out[j] = nums[i];
            j++;
        }

        return out;
    }
}
