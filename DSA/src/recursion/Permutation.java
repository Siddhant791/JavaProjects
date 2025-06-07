package src.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        return recursion(0 , output , nums);
    }

    private List<List<Integer>> recursion(int index , List<List<Integer>> output , int[] nums){
        if (index == nums.length) {
            output.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return output;
        }

        for (int i = index ; i < nums.length ; i++){
            swap(i, index, nums);
            recursion(index + 1, output , nums);
            swap(i, index, nums);
        }
        return output;
    }

    private void swap(int a , int b , int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
