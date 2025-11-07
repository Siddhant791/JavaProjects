package src.Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class RemoveElement {
    /*
     * LeetCode: https://leetcode.com/problems/remove-element/
     *
     * Problem summary:
     *  Given an integer array nums and an integer val, remove all occurrences of val in-place.
     *  Return the new length k after removal. The relative order of the remaining elements may be changed.
     *
     * Techniques / Patterns used:
     *  - removeElement: Two pointers (fast/slow) — in-place overwrite.
     *  - removeElementWithQueue: Index tracking using a Queue (alternate approach demonstrating reuse of freed indices).
     *
     * Complexity:
     *  - removeElement:
     *      Time: O(n) — single pass over the array.
     *      Space: O(1) — constant extra space (in-place).
     *  - removeElementWithQueue:
     *      Time: O(n) — single pass, queue operations O(1) amortized.
     *      Space: O(m) worst-case (m = number of removed elements, up to O(n)).
     *
     * Notes:
     *  - The canonical solution is the two-pointer approach (removeElement) for simplicity and O(1) space.
     *  - removeElementWithQueue is educational: it explicitly tracks freed indices and reuses them.
     */
    public int removeElement(int[] nums, int val) {
        // slow pointer k: next write position for elements != val
        int k = 0;
        // iterate with fast pointer i over all elements
        for(int i = 0; i<nums.length ;i++){
            // if current element should be kept, write it at position k and increment k
            if (nums[i] != val){
                nums[k] = nums[i];
                k+=1;
            }
            // if element == val, skip it (do not advance k), effectively removing it
        }
        // k is the length of the array after removals
        return k;
    }

    /*
     * Alternate approach that uses a Queue to store indices of removed elements.
     * When a non-val element is found and there is a freed index available,
     * the element is moved to that freed index and the current index becomes freed.
     */
    public int removeElementWithQueue(int[] nums, int val) {
        Queue<Integer> queue = new LinkedList<>();
        // out counts kept elements (resulting length)
        int out = 0;
        // iterate through array with index i
        for(int i = 0; i<nums.length ;i++){
            if (nums[i] != val) {
                // current element is kept
                out++;
                // if we have a previously freed index, move this element there
                if (!queue.isEmpty()){
                    int index = queue.poll(); // reuse earliest freed index
                    nums[index] = nums[i];   // place current value into freed slot
                    queue.offer(i);          // current index becomes a freed slot now
                }
                // if queue is empty, no freed slot to reuse — element stays in place
            } else {
                // element equals val, record its index as freed for future overwrites
                queue.offer(i);
            }
        }
        return out;
    }
}