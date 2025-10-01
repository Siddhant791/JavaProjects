package src;

import src.recursion.Permutation;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainDSA {

    private static void mergeSort(int arr[], int left ,  int right){
        if (left < right){
            int mid = (left + right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Test");

//        List<Integer> input = new ArrayList<>();
        int[] input = new int[5];

        int mid = input.length/2;

        input[0] = 5;
        input[1] = 3;
        input[2] = 6;
        input[3] = 2;
        input[4] = 1;


        // Thread

        ExecutorService exe = Executors.newFixedThreadPool(3);

        exe.submit(() -> mergeSort(input, 0, mid));

        Thread t1 = new Thread( () -> mergeSort(input, 0, mid)); // First half by thread one
        Thread t2 = new Thread(() -> mergeSort(input, mid, input.length - 1)); // Second half by thread two

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        merge(input, 0, mid -1, input.length - 1);

        System.out.println(Arrays.toString(input));
    }

//    public static class Solution {
//        public int rob(int[] nums) {
//            if (nums.length == 0) {
//                return 0;
//            }
//            if (nums.length == 1){
//                return nums[0];
//            }
//            int indexEven = 0;
//            int indexOdd = 1;
//            int sumEven = 0;
//            int sumOdd = 0;
//
//            while(indexEven < nums.length || indexOdd < nums.length){
//                if (indexEven < nums.length ) {
//                    sumEven+=nums[indexEven];
//                }
//                if (indexOdd < nums.length ) {
//                    sumOdd+=nums[indexOdd];
//                }
//                indexEven+=2;
//                indexOdd+=2;
//            }
//
//            return Math.max(indexEven,indexOdd);
//        }
//    }
}



// Second largest element in array
// [1,2,4]
// Sort the array
