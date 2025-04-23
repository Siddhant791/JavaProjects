package stack;

import java.util.Stack;
// leet code 155. Min Stack
public class MinStack {
    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> mainStack = new Stack<>();

    public MinStack() {
    }

    public void push(int val) {
        // Checking base condition i.e. empty stack
        if (minStack.isEmpty() || mainStack.isEmpty()){
            mainStack.push(val);
            minStack.push(val);
        }else{
            // if value is greater than mainStack
            if(val > minStack.peek()){
                minStack.push(minStack.peek()); // duplicating the minimum value to maintain same total no. of elements in both the stacks
                mainStack.push(val);
            }
            // if value is smaller that means it's smallest value
            else {
                mainStack.push(val);
                minStack.push(val);
            }
        }
    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */