package src.priorityQueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskSceduler {
    public int leastInterval(char[] tasks, int n) {
        int[] countArray = new int[26];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();

        // Calculating the total no. of each tasks present
        for (char task : tasks){
            countArray[task - 'A']++;
        }

        // Adding the counts of each total no. of tasks in the heap
        for (int count : countArray){
            if (count > 0){
                maxHeap.add(count);
            }
        }

        int time = 0;

        while (!q.isEmpty() || !maxHeap.isEmpty()){
            time++; // Process next task

            // If max heap is empty that means we need to wait for idle time in the latest element in queue
            // Or the time remaing for last element which was processed
            if (maxHeap.isEmpty()){
                time = q.peek()[1];
            }else{
                // If the heap is not empty then we need to process the next max element present in the heap
                int count = maxHeap.poll() - 1;
                if (count> 0){
                    q.add(new int[]{count,  time + n});
                }
            }

            // if the waiting time for the latest element in queue is over then we should remove it from waiting queue
            // and put it back to heap

            if (!q.isEmpty() && q.peek()[1] == time){
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;
    }
}
