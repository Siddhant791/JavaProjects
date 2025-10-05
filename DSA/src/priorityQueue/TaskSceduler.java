package src.priorityQueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskSceduler {
    /**
     * LeetCode Problem: 621. Task Scheduler
     * Link: https://leetcode.com/problems/task-scheduler/
     *
     * This method calculates the least amount of time the CPU needs to complete all given tasks.
     * It uses a greedy approach combined with a max-heap and a queue to manage task execution and cooldown periods.
     *
     * Algorithm/Pattern: Greedy, Priority Queue (Max-Heap), Queue
     *
     * Time Complexity: O(N), where N is the total number of tasks.
     * In the worst case, we iterate through all tasks to count frequencies, and then the while loop runs
     * at most N times (each task is processed once). The heap operations (add, poll) take O(logK) where K is the number of unique tasks (at most 26).
     * Since K is a constant (26), logK is also a constant.
     *
     * Space Complexity: O(1), as the `countArray` is of size 26, `maxHeap` stores at most 26 elements,
     * and `q` stores at most `n+1` elements (which is also bounded by 26 in practical scenarios for n < 26, or constant if n is large).
     */
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

            // If the maxHeap is empty, it means all available tasks have been processed and are currently in cooldown.
            // We must fast-forward time to the point where the next task becomes available from the queue.
            if (maxHeap.isEmpty()){
                // Update time to the earliest time a task in the queue becomes available.
                time = q.peek()[1];
            }else{
                // If the heap is not empty, we can process the task with the highest remaining frequency.
                int count = maxHeap.poll() - 1;
                // If the task still has remaining occurrences, add it to the cooldown queue.
                if (count> 0){
                    // The task will be available again after 'n' units of time from the current 'time'.
                    q.add(new int[]{count,  time + n});
                }
            }

            // Check if any tasks in the cooldown queue are ready to be processed again.
            // If the waiting time for the task at the front of the queue is over (i.e., its availability time
            // is less than or equal to the current 'time'), remove it from the queue and add it back to the maxHeap.
            // This allows it to be considered for processing in the next cycle.
            // Note: q.peek()[1] == time ensures we only re-add tasks that are *just* becoming available at the current 'time'.

            if (!q.isEmpty() && q.peek()[1] == time){
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;
    }
}
