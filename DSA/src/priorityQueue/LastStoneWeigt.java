package src.priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeigt {
    /**
     * LeetCode Problem: 1046. Last Stone Weight
     * Link: https://leetcode.com/problems/last-stone-weight/
     *
     * Problem Description:
     * We are given an array of integers `stones` where `stones[i]` is the weight of the i-th stone.
     * We are playing a game with these stones. On each turn, we choose the heaviest two stones and smash them together.
     * Suppose the heaviest two stones have weights `x` and `y` with `x <= y`.
     * - If `x == y`, both stones are totally destroyed.
     * - If `x != y`, the stone of weight `x` is totally destroyed, and the stone of weight `y` has new weight `y - x`.
     * At the end of the game, there is at most one stone left.
     * Return the weight of the last remaining stone. If there are no stones left, return 0.
     *
     * Technique/Pattern: Max Heap (Priority Queue)
     * This problem is a classic application of a max heap because we repeatedly need to find and remove the two largest elements.
     *
     * Time Complexity: O(N log N)
     * - Building the heap: O(N) for adding N elements.
     * - While loop: In the worst case, we perform N/2 smash operations. Each smash involves two `poll` operations (O(log N) each)
     *   and potentially one `add` operation (O(log N)). So, N/2 * O(log N) = O(N log N).
     * Overall, the dominant factor is O(N log N).
     *
     * Space Complexity: O(N)
     * - The `PriorityQueue` stores up to N stones.
     */
    public int lastStoneWeight(int[] stones) {
        int output = 0; // Initialize output to 0, in case no stones are left.

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder()); // Create a max-heap to store stone weights.

        for (int weight : stones){
            heap.add(weight); // Add all stone weights to the max-heap.
        }

        while (!heap.isEmpty()){ // Continue as long as there are stones in the heap.
            Integer first = heap.poll(); // Get the heaviest stone (y).
            Integer second = heap.poll(); // Get the second heaviest stone (x).
            if (second == null){ // If there's only one stone left (second is null), it's the last one.
                output = first; // Store its weight.
                break; // Exit the loop.
            }

            int difference = first - second; // Calculate the difference in weights (y - x).

            if (difference != 0){ // If the difference is not zero, a new stone is formed.
                heap.add(difference); // Add the new stone's weight back to the heap.
            }
        }

        return output; // Return the weight of the last remaining stone, or 0 if none.
    }
}
