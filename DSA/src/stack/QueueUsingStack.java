package src.stack;

import java.util.Stack;

public class QueueUsingStack {

}

/* LeetCode: Implement Queue using Stacks
 * Link: https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * Problem:
 *  - Implement a FIFO queue using two LIFO stacks.
 *  - Support push(x), pop(), peek(), and empty() operations.
 *
 * Technique / Pattern:
 *  - Two-stacks technique (input/output stacks), also called lazy transfer.
 *  - stackTemp = input stack (enqueue); queue = output stack (dequeue).
 *  - Transfer elements only when needed (when output stack is empty and a pop/peek is requested).
 *
 * Complexity:
 *  - push: O(1) time.
 *  - pop: Amortized O(1) time, worst-case O(n) when transferring elements from input to output.
 *  - peek: Amortized O(1) time, worst-case O(n) when transferring.
 *  - empty: O(1) time.
 *  - Space: O(n) total for stored elements across both stacks.
 */
class MyQueue {
    // stackTemp: input stack where new elements are pushed (enqueue).
    Stack<Integer> stackTemp = new Stack<>();
    // queue: output stack used to pop/peek elements in FIFO order.
    Stack<Integer> queue = new Stack<>();
    public MyQueue() {
        // No initialization required beyond the field inits above.
    }

    public void push(int x) {
        // Enqueue operation: push onto input stack.
        // O(1) time. We do not move elements to the output stack here (lazy).
        stackTemp.push(x);
    }

    public int pop() {
        // Dequeue operation:
        // If output stack has elements, pop and return directly (O(1)).
        if (!queue.isEmpty()){
            return queue.pop();
        }

        // If both stacks empty, nothing to pop. Return sentinel (-1) in this implementation.
        if (stackTemp.isEmpty()){
            return -1;
        }

        // Transfer all elements from input to output to reverse order:
        // After transfer, the oldest enqueued element is on top of 'queue'.
        // This transfer is O(n) but happens infrequently -> amortized O(1).
        while (!stackTemp.isEmpty()){
            queue.push(stackTemp.pop());
        }
        return queue.pop();
    }

    public int peek() {
        // Similar to pop but returns the front element without removing it.
        // If output stack has elements, the top is the front of the queue.
        if (!queue.isEmpty()){
            return queue.peek();
        }

        // If queue is empty overall, return sentinel (-1).
        if (stackTemp.isEmpty()){
            return -1;
        }

        // Transfer to expose the oldest element on top of 'queue'.
        while (!stackTemp.isEmpty()){
            queue.push(stackTemp.pop());
        }
        return queue.peek();
    }

    public boolean empty() {
        // The queue is empty only when both stacks are empty.
        return stackTemp.isEmpty() && queue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
