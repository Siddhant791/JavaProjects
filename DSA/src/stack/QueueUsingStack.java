package src.stack;

import java.util.Stack;

public class QueueUsingStack {

}

class MyQueue {
    Stack<Integer> stackTemp = new Stack<>();
    Stack<Integer> queue = new Stack<>();
    public MyQueue() {

    }

    public void push(int x) {
        stackTemp.push(x);
    }

    public int pop() {
        if (!queue.isEmpty()){
            return queue.pop();
        }

        if (stackTemp.isEmpty()){
            return -1;
        }

        while (!stackTemp.isEmpty()){
            queue.push(stackTemp.pop());
        }
        return queue.pop();
    }

    public int peek() {
        if (!queue.isEmpty()){
            return queue.peek();
        }

        if (stackTemp.isEmpty()){
            return -1;
        }

        while (!stackTemp.isEmpty()){
            queue.push(stackTemp.pop());
        }
        return queue.peek();
    }

    public boolean empty() {
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
