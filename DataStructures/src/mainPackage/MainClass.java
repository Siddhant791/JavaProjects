package mainPackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MainClass {

	public static void main(String[] args) throws Exception {
		System.out.println('B'-'a');
//		int[] arr = {2,1,3,3};
//		int[] out = maxSubsequence(arr, 2);
//		for(int z:out) {
//			System.out.println(z);
//		}
	}
	
    public  static int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        Object[] temp = new Object[nums.length];
        int[] output = new int[k];
        int count = 0;
        
        for(int n = 0;n<nums.length;n++){
            if(n>=0){
                maxHeap.add(nums[n]);
                map.put(nums[n],n);
            }else{
                minHeap.add(nums[n]);
                map.put(nums[n],n);
            }
        }
        
        for(int i = 0; i<k;i++){
            if(!maxHeap.isEmpty()){
                int index = map.get(maxHeap.peek());
                temp[index] = maxHeap.poll();
            }else{
                int index = map.get(minHeap.peek());
                temp[index] = minHeap.poll();
            }
        }
        
        for(Object o:temp){
            if(o!=null){
                output[count++] = (int)o;
            }
        }
        return output;
    }
	
}
