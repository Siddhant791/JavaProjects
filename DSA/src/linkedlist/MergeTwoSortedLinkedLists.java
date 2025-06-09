package src.linkedlist;

/**
 * LeetCode 21 - Merge Two Sorted Lists
 *
 * Problem Statement:
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by
 * splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * Example:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Constraints:
 * - The number of nodes in both lists is in the range [0, 50]
 * - -100 <= Node.val <= 100
 * - Both list1 and list2 are sorted in non-decreasing order
 */
public class MergeTwoSortedLinkedLists {

    /**
     * Definition for singly-linked list node
     * Each node contains an integer value and a pointer to the next node
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        /**
         * Merges two sorted linked lists into a single sorted linked list
         *
         * Approach:
         * 1. Create a dummy node as the head of merged list
         * 2. Compare nodes from both lists and add smaller value to result
         * 3. Move pointers forward in the lists being compared
         * 4. Handle remaining nodes in either list
         *
         * Time Complexity: O(n + m) where:
         * - n is the length of list1
         * - m is the length of list2
         * - We traverse each node exactly once
         *
         * Space Complexity: O(1) as we only use a few pointers
         * Note: The space for output list is not counted as extra space
         * as it's part of the required output
         *
         * @param list1 Head of first sorted linked list
         * @param list2 Head of second sorted linked list
         * @return Head of merged sorted linked list
         */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // Handle edge cases where either list is null
            if (list1 == null){
                return list2;
            }
            if (list2 == null){
                return list1;
            }

            // Create dummy node to avoid edge cases in insertion
            ListNode output = new ListNode();
            ListNode temp = output;  // Pointer to build merged list

            // Continue while there are nodes in either list
            while(list1 != null || list2!= null ) {
                // If list1 is exhausted, add remaining nodes from list2
                if (list1 == null) {
                    temp.next = new ListNode(list2.val);
                    list2 = list2.next;
                    temp = temp.next;
                    continue;
                }

                // If list2 is exhausted, add remaining nodes from list1
                if (list2 == null) {
                    temp.next = new ListNode(list1.val);
                    list1 = list1.next;
                    temp = temp.next;
                    continue;
                }

                // Compare current nodes and add smaller value to result
                if (list1.val <= list2.val){
                    temp.next = new ListNode(list1.val);
                    list1 = list1.next;      // Move list1 pointer forward
                }else{
                    temp.next = new ListNode(list2.val);
                    list2 = list2.next;      // Move list2 pointer forward
                }
                temp = temp.next;            // Move result pointer forward
            }

            // Return merged list (skip dummy node)
            return output.next;
        }
    }
}
