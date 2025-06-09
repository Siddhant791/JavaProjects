package src.linkedlist;

/**
 * LeetCode 143 - Reorder List
 *
 * Problem Statement:
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → L2 → ... → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → ...
 *
 * Example:
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 *
 * Constraints:
 * - The number of nodes in the list is in the range [1, 5 * 10^4]
 * - 1 <= Node.val <= 1000
 */
public class ReorderList {
    /**
     * Definition for singly-linked list node
     * Each node contains a value and a pointer to the next node
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {

        /**
         * Main method to reorder the linked list
         * Algorithm works in three steps:
         * 1. Find the middle of the list using slow/fast pointers
         * 2. Reverse the second half of the list
         * 3. Merge the first half with the reversed second half
         *
         * Time Complexity: O(n) where n is the number of nodes
         * - Finding middle: O(n/2)
         * - Reversing second half: O(n/2)
         * - Merging lists: O(n/2)
         * Space Complexity: O(1) as we only use a constant amount of extra space
         *
         * @param head Head of the linked list to be reordered
         */
        public void reorderList(ListNode head) {
            // Handle edge cases
            if (head == null || head.next == null) return;

            // Step 1: Find the middle of the list
            // Fast pointer moves twice as fast as slow pointer
            ListNode fast = head.next;
            ListNode slow = head;

            while(fast != null && fast.next != null) {
                slow = slow.next;          // Move slow one step
                fast = fast.next.next;     // Move fast two steps
            }

            // Step 2: Reverse the second half of the list
            // First, split the list into two parts
            ListNode second = slow.next;   // Start of second half
            ListNode prev = slow.next = null;  // Break the link and initialize prev
            ListNode temp = null;

            // Reverse the second half
            while(second != null) {
                temp = second.next;        // Store next node
                second.next = prev;        // Reverse the link
                prev = second;             // Move prev forward
                second = temp;             // Move to next node
            }

            // Step 3: Merge the two halves
            // 'first' points to start of first half
            // 'second' (prev) points to start of reversed second half
            ListNode first = head;
            second = prev;

            while(second != null) {
                // Store next nodes of both lists
                ListNode temp1 = first.next;
                ListNode temp2 = second.next;

                // Connect nodes in new order
                first.next = second;       // Connect first to last
                second.next = temp1;       // Connect last to second

                // Move pointers forward
                first = temp1;
                second = temp2;
            }
        }

    }
}
