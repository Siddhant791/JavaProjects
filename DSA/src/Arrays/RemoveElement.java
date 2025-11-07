package src.Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i = 0; i<nums.length ;i++){
            if (nums[i] != val){
                nums[k] = nums[i];
                k+=1;
            }
        }
        return k;
    }

     public int removeElementWithQueue(int[] nums, int val) {
         Queue<Integer> queue = new LinkedList<>();
         int out = 0;
         for(int i = 0; i<nums.length ;i++){
             if (nums[i] != val) {
                 out++;
                 if (!queue.isEmpty()){
                     int index = queue.poll();
                     nums[index] = nums[i];
                     queue.offer(i);
                 }
             } else {
                 queue.offer(i);
             }
         }
         return out;
     }


}
