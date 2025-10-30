package src.priorityQueue;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for (int i : nums){
            minHeap.offer(i);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
