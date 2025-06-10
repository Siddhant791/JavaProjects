package src.linkedlist;

/**
 * LeetCode 141 - Linked List Cycle
 *
 * Problem Statement:
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached
 * again by continuously following the next pointer.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Example:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 *
 * Constraints:
 * - The number of nodes in the list is in the range [0, 10^4]
 * - -10^5 <= Node.val <= 10^5
 * - pos is -1 or a valid index in the linked-list
 */
public class LinkedListCycle {

    /**
     * Definition for singly-linked list node
     * Each node contains an integer value and a pointer to the next node
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Detects if there is a cycle in the linked list using Floyd's Cycle-Finding Algorithm
     * (also known as "tortoise and hare" algorithm)
     *
     * Approach:
     * 1. Use two pointers: slow (moves 1 step) and fast (moves 2 steps)
     * 2. If there's a cycle, fast pointer will eventually catch up to slow pointer
     * 3. If there's no cycle, fast pointer will reach null
     *
     * Time Complexity: O(n) where n is the number of nodes
     * - In worst case (no cycle), we traverse all nodes once
     * - In case of cycle, fast pointer will catch slow pointer in at most n steps
     *
     * Space Complexity: O(1)
     * - Only using two pointers regardless of input size
     *
     * @param head Head of the linked list
     * @return true if cycle exists, false otherwise
     */
    public boolean hasCycle(ListNode head) {
        // Handle edge cases: empty list or single node
        if (head == null || head.next == null){
            return false;
        }

        // Initialize slow and fast pointers
        ListNode slow = head;            // Moves one step at a time
        ListNode fast = head.next;       // Moves two steps at a time

        // Continue until fast reaches end or catches up to slow
        while(fast != null && fast.next != null && slow != null){
            slow = slow.next;           // Move slow one step
            fast = fast.next.next;      // Move fast two steps

            // If fast catches up to slow, we found a cycle
            if(slow == fast){
                return true;
            }
        }

        // If we exit the loop, no cycle was found
        return false;
    }
}
