package src.twopointers;

public class ContainersWithWater {
/**
 * LeetCode 11: Container With Most Water
 *
 * Problem:
 * Given an array `height` of n non-negative integers where each element represents a vertical line
 * at coordinate i with height `height[i]`, find two lines that together with the x-axis form a
 * container that holds the most water. Return the maximum amount of water the container can store.
 *
 * Technique/Pattern: Two Pointers
 *
 * Approach:
 * - Use two pointers (`start` at the beginning and `end` at the end) to consider the widest container first.
 * - Calculate area using the shorter of the two lines times the width (end - start).
 * - Move the pointer at the shorter line inward to potentially find a taller line that increases area.
 * - Repeat until pointers meet.
 *
 * Complexity Analysis:
 * - Time: O(n) — each pointer moves at most n steps total.
 * - Space: O(1) — only constant extra space for pointers and the result.
 *
 * @param height An array of non-negative integers representing the heights of vertical lines.
 * @return The maximum area of water that can be contained.
 */
public int maxArea(int[] height) {
    // Pointer at the start of the array
    int start = 0;
    // Pointer at the end of the array
    int end = height.length - 1;
    // Store the maximum area found so far
    int output = 0;

    // Iterate while the two pointers haven't met
    while (start < end){
        // The container height is limited by the shorter of the two lines
        int minimumHeightBetweenTwoPoles = Math.min(height[start], height[end]);
        // Compute area = width * height and update max area
        output = Math.max((end - start) * minimumHeightBetweenTwoPoles, output);

        // Move the pointer at the shorter line inward, since moving the taller line
        // cannot increase the height of the limiting side and would only reduce width.
        if (height[start] <= height[end]) {
            start++;
        } else {
            end--;
        }
    }

    return output;
}
}
