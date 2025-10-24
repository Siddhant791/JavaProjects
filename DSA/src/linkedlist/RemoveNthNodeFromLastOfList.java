package src.linkedlist;

/**
 * LeetCode Problem: 19. Remove Nth Node From End of List
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Problem Description:
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * Technique Used: Two Pointers (specifically, the "fast and slow" or "two-pointer with a gap" approach).
 *
 * Complexity Analysis:
 * Time Complexity: O(L), where L is the number of nodes in the linked list.
 * We iterate through the list at most twice (once to move the right pointer, and once more for both pointers to traverse).
 * In the worst case, both pointers traverse the entire list.
 *
 * Space Complexity: O(1).
 * We only use a few extra pointers (dummy, left, right), which consume constant space regardless of the list size.
 */
public class RemoveNthNodeFromLastOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge cases, especially when the head itself needs to be removed.
        // The dummy node points to the original head.
        // This simplifies the logic as we don't need to special-case removing the head.
        ListNode dummy = new ListNode(0,head);
        // Initialize the 'right' pointer to the head of the list.
        ListNode right = head;
        // Initialize the 'left' pointer to the dummy node.
        // This ensures that when 'right' reaches the end, 'left' will be at the node *before* the one to be removed.
        ListNode left = dummy;

        // Move the 'right' pointer 'n' steps ahead.
        // This creates a gap of 'n' nodes between 'left' and 'right'.
        // After this loop, 'right' will be 'n' nodes ahead of 'left'.
        // Time Complexity: O(n)
        while (n > 0){
            right = right.next;
            n--;
        }

        // Move both 'left' and 'right' pointers simultaneously until 'right' reaches the end of the list (null).
        // When 'right' becomes null, 'left' will be pointing to the node *before* the nth node from the end.
        // Time Complexity: O(L - n), where L is the length of the list.
        while (right!=null){
            left =left.next;
            right = right.next;
        }

        // At this point, 'left' is at the node just before the one to be removed.
        // 'left.next' is the node to be removed.
        // 'left.next.next' is the node after the one to be removed.
        // By setting 'left.next = left.next.next', we effectively bypass and remove the nth node from the end.
        left.next = left.next.next;
        // Return the next of the dummy node, which is the new head of the list.
        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {} // Default constructor
        ListNode(int val) { this.val = val; } // Constructor with value
        ListNode(int val, ListNode next) { this.val = val; this.next = next; } // Constructor with value and next node
    }
}
