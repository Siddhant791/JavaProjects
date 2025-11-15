package src.stack;

import java.util.Stack;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        Stack<Integer> stack = new Stack<>();

        for (String s : logs) {
            if (s.contains("..") && !stack.isEmpty()) {
                stack.pop();
            }
            else if ( s.startsWith(".")) {
                continue;
            } else {
                stack.push(1);
            }
        }

        return stack.size();
    }
}
