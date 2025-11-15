package src.stack;

import java.util.Stack;

public class CrawlerLogFolder {
    /*
     * LeetCode: https://leetcode.com/problems/crawler-log-folder/
     *
     * Problem summary:
     *  - Given an array of strings logs representing filesystem operations:
     *      "x"   -> move into a child folder named x
     *      "."   -> stay in the current folder
     *      ".."  -> move to the parent folder (if possible)
     *  - Return the minimum number of operations required to go back to the main folder
     *    (equivalently, the final depth).
     *
     * Technique/Pattern:
     *  - Simulation using a stack (or equivalently a depth counter). This is a straightforward
     *    simulation / state machine pattern.
     *
     * Complexity:
     *  - Time: O(n) where n = logs.length. Each log entry is processed once with O(1) work.
     *  - Space: O(n) worst-case for the stack (every log is a simple folder name).
     *           Note: this can be reduced to O(1) by using an integer depth counter instead
     *           of an explicit stack (push -> depth++, pop -> depth--).
     *
     * Breakdown by section:
     *  - Stack creation: O(1) time to create, O(n) potential space as elements are pushed.
     *  - Loop over logs: O(n) total time. Each branch (pop, skip, push) is O(1).
     *  - Return size: O(1).
     */

    public int minOperations(String[] logs) {
        // Use a stack to simulate current depth. Each push represents entering a directory.
        Stack<Integer> stack = new Stack<>();

        // Process each log entry once.
        for (String s : logs) {
            // If the log indicates moving up to parent (\"..\") and there is a folder to pop,
            // then pop one level.
            if (s.contains("..") && !stack.isEmpty()) {
                stack.pop(); // O(1)
            }
            // If the log is a single dot (current folder), do nothing and continue.
            else if ( s.startsWith(".")) {
                continue; // stay in the same directory
            } else {
                // Otherwise it's a valid folder name: push a dummy value to represent depth.
                // Using 1 as a placeholder; only stack size matters.
                stack.push(1); // O(1)
            }
        }

        // The current depth is the size of the stack.
        return stack.size();
    }
}