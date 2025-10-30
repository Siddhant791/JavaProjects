package src.priorityQueue;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    // LeetCode Problem: Kth Largest Element in a Stream
    // Link: https://leetcode.com/problems/kth-largest-element-in-a-stream/
    // Technique: Min-Heap (Priority Queue)
    // This problem uses a min-heap to efficiently keep track of the 'k' largest elements seen so far.
    // By maintaining a min-heap of size 'k', the smallest element in the heap is always the Kth largest element overall.

    // A min-heap to store the k largest elements.
    // The smallest element in this heap will be the Kth largest element.
    PriorityQueue<Integer> minHeap;
    // The 'k' value, representing the Kth largest element we need to find.
    int k;

    /**
     * Constructor to initialize the KthLargestElementInAStream object.
     *
     * @param k    The 'k' value for the Kth largest element.
     * @param nums An initial array of numbers.
     *
     * Time Complexity: O(N log K), where N is the number of elements in 'nums'.
     *                  Each insertion into the min-heap takes O(log K) time, and we do this N times.
     * Space Complexity: O(K), as the min-heap will store at most K elements.
     */
    public KthLargestElementInAStream(int k, int[] nums) {
        // Initialize the min-heap.
        minHeap = new PriorityQueue<>();
        // Store the given 'k' value.
        this.k = k;
        // Process each number in the initial array.
        for (int i : nums){
            // Add the current number to the min-heap.
            minHeap.offer(i);
            // If the heap size exceeds 'k', remove the smallest element (root of min-heap).
            // This ensures that the heap always contains the 'k' largest elements encountered so far.
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
    }

    /**
     * Adds a new value to the stream and returns the Kth largest element.
     *
     * @param val The new integer value to add to the stream.
     * @return The Kth largest element in the stream after adding 'val'.
     *
     * Time Complexity: O(log K).
     *                  Adding an element to the min-heap takes O(log K) time.
     *                  Removing an element (if size > k) also takes O(log K) time.
     *                  Peeking at the top element takes O(1) time.
     * Space Complexity: O(K) (maintained by the constructor and subsequent calls).
     */
    public int add(int val) {
        // Add the new value to the min-heap.
        // This operation takes O(log K) time.
        minHeap.add(val);

        // If the heap size exceeds 'k', remove the smallest element.
        // This maintains the property that the heap only stores the 'k' largest elements.
        // This operation takes O(log K) time.
        if (minHeap.size() > k){
            minHeap.poll();
        }

        // The Kth largest element is always at the root of the min-heap (the smallest element in the heap).
        // This operation takes O(1) time.
        return minHeap.peek();
    }
}
