package src.stack;

import java.util.Stack;

/*
 LeetCode: https://leetcode.com/problems/daily-temperatures/  (Problem 739)

 Problem summary:
 Given an array of daily temperatures, return an array such that for each day
 you output the number of days until a warmer temperature. If there is no
 future day for which this is possible, put 0.

 Techniques / Patterns used:
 - Monotonic stack (maintain indices of temperatures in strictly decreasing order)
 - Two-pointer style (in `dailyTemperaturesStackFromBack` we scan from right to left)
 - Brute force (nested loops) for straightforward reference / verification

 Complexity summaries:
 - dailyTemperatures (forward monotonic stack):
   Time: O(n) — each index is pushed and popped at most once.
   Space: O(n) — stack may hold up to n indices and output array uses n.
 - dailyTemperaturesBruteForce:
   Time: O(n^2) — nested loops scanning future days for each day.
   Space: O(n) — output array only.
 - dailyTemperaturesStackFromBack (reverse monotonic stack):
   Time: O(n) — each element pushed/popped at most once while scanning from right.
   Space: O(n) — stack holds pairs (value, index) up to n and output array uses n.

 Notes:
 - All existing inline comments in the code are preserved and left intact.
 - The monotonic stack approaches produce the same results but demonstrate two
   common variants: scanning left-to-right while storing indices of unresolved
   days, and scanning right-to-left while storing candidate greater elements.
*/

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temps) {
        // Approach: forward monotonic stack of indices.
        // Maintain a stack of indices whose temperatures are in decreasing order.
        // When a higher temperature is found, pop indices and set their result
        // to the difference in indices (days).
        // Time: O(n), Space: O(n)
        int n = temps.length;
        int[] out = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                out[stack.peek()] = i - stack.pop();
            }
            stack.add(i);
        }

        return out;
    }

    public int[] dailyTemperaturesBruteForce(int[] temps) {
        // Approach: brute force nested loops.
        // For each day, scan subsequent days until a warmer one is found.
        // Time: O(n^2), Space: O(n)
        int count;
        int n = temps.length;
        int[] out = new int[n];

        for (int i = 0; i < n; i++) {
            // Reset the counter to compute the next value count in the array
            count = 1;
            for (int j = i + 1; j < n; j++) {
                if (temps[j] > temps[i]) {
                    out[i] = count;
                    break;
                }
                count++;
            }
        }

        return out;


    }

    public int[] dailyTemperaturesStackFromBack(int[] temps) {
        // Approach: reverse scan using a monotonic stack.
        // We scan from the end towards the front and maintain a stack of pairs
        // [temperature, index] where temperatures in the stack are strictly
        // increasing from bottom to top (so top is the next warmer day).
        // For each element we pop smaller or equal elements, then the top (if any)
        // gives the next warmer day.
        // Time: O(n), Space: O(n)
        Stack<int[]> stack = new Stack<>();
        int n = temps.length;
        int i = n - 1;
        int[] out = new int[n];

        while (i >= 0) {
            if (stack.isEmpty()) {
                stack.add(new int[]{temps[i], i});
                out[i] = 0;
                i--;
                continue;
            }

            // If new element is greater than the stack peeked element then the existing element doesn't need to be in stack
            // So we pop it out
            while (!stack.isEmpty() && temps[i] >= stack.peek()[0]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                out[i] = 0;
            } else {

                // Once we get the greater element that means that's the next greater element
                out[i] = stack.peek()[1] - i;
            }
        }
    }
}