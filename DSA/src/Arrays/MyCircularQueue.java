package src.Arrays;

/**
 * LeetCode 622 - Design Circular Queue
 *
 * Problem Statement:
 * Design your implementation of the circular queue. The circular queue is a linear data structure
 * in which the operations are performed based on FIFO (First In First Out) principle, and the
 * last position is connected back to the first position to make a circle.
 *
 * Implement the MyCircularQueue class:
 * - MyCircularQueue(k) Initializes the object with the size of the queue to be k.
 * - boolean enQueue(int value) Inserts an element into the circular queue. Returns true if successful.
 * - boolean deQueue() Deletes an element from the circular queue. Returns true if successful.
 * - int Front() Gets the front item from the queue. Returns -1 if queue is empty.
 * - int Rear() Gets the last item from the queue. Returns -1 if queue is empty.
 * - boolean isEmpty() Checks whether the circular queue is empty or not.
 * - boolean isFull() Checks whether the circular queue is full or not.
 *
 * Example:
 * Input: ["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 * Output: [null, true, true, true, false, 3, true, true, true, 4]
 */
public class MyCircularQueue {

    // Array to store queue elements
    private int[] queue;
    // Current number of elements in the queue
    private int currentSize;
    // Index of the front element
    private int front = 0;
    // Index of the rear element
    private int rear = -1;

    /**
     * Initialize circular queue with given size
     * Time Complexity: O(1)
     * Space Complexity: O(k) where k is the size of queue
     */
    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.currentSize = 0;
    }

    /**
     * Insert element at rear of queue
     * Uses modulo operator to wrap around the array
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @param value element to be inserted
     * @return true if insertion successful, false if queue is full
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % queue.length;  // Wrap around using modulo
        queue[rear] = value;
        currentSize++;
        return true;
    }

    /**
     * Remove element from front of queue
     * Uses modulo operator to wrap around the array
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @return true if deletion successful, false if queue is empty
     */
    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        front = (front + 1) % queue.length;  // Wrap around using modulo
        currentSize--;
        return true;
    }

    /**
     * Get front element of queue
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @return front element if queue not empty, -1 if empty
     */
    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    /**
     * Get rear element of queue
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @return rear element if queue not empty, -1 if empty
     */
    public int Rear() {
        return isEmpty() ? -1 : queue[rear];
    }

    /**
     * Check if queue is empty
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @return true if queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Check if queue is full
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @return true if queue is full, false otherwise
     */
    public boolean isFull() {
        return currentSize == queue.length;
    }
}

