import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        List<Integer> list = new ArrayList<>();
//        int[] input = {2,5,4};
//
//        Stack<Integer> stack = new Stack<>();
//        Integer largest = input[0];
//        Integer SecondLargest = Integer.MIN_VALUE;
//        for(int i: input){
//            if(largest < i) {
//                SecondLargest = largest;
//                largest = i;
//            }
//        }
//
//        System.out.println(SecondLargest);

        int[] array = new int[5];
        System.out.println(Arrays.toString(array));

        Solution solution = new Solution();
        int[] input = {1,2,3,1};
        int result = solution.rob(input);
        System.out.println(result);

    }

    public static class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1){
                return nums[0];
            }
            int indexEven = 0;
            int indexOdd = 1;
            int sumEven = 0;
            int sumOdd = 0;

            while(indexEven < nums.length || indexOdd < nums.length){
                if (indexEven < nums.length ) {
                    sumEven+=nums[indexEven];
                }
                if (indexOdd < nums.length ) {
                    sumOdd+=nums[indexOdd];
                }
                indexEven+=2;
                indexOdd+=2;
            }

            return Math.max(indexEven,indexOdd);
        }
    }
}



// Second largest element in array
// [1,2,4]
// Sort the array