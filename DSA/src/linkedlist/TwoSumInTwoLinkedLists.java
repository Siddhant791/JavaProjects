package linkedlist;

/**
 * This class implements the solution for adding two numbers represented by linked lists
 * The numbers are stored in reverse order, and each node contains a single digit
 * Example: 2->4->3 represents 342
 * Node structure for the linked list (LeetCode Problem 2: Add Two Numbers)
 */
public class TwoSumInTwoLinkedLists {
    
    /**
     * Node structure for the linked list
     * Each node contains a value and a pointer to the next node
     */
    static class ListNode {
        // ... existing code ...
        public ListNode next;
        public int val;
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        /**
         * Adds two numbers represented by linked lists and returns the sum as a linked list
         * @param l1 First number represented as linked list
         * @param l2 Second number represented as linked list
         * @return Sum of two numbers as a linked list
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // Handle edge case when either list is null
            if (l1 == null || l2 == null){
                return null;
            }

            // Create pointers to traverse both lists
            ListNode tempL1 = l1;
            ListNode tempL2 = l2;
            int carry = 0;  // To store carry forward value
            
            // Initialize result linked list with dummy head node
            ListNode output = new ListNode(0);
            ListNode output1 = output;  // Keep track of head for return

            // Process both lists until we reach end of both
            while(tempL1 !=null || tempL2 != null){
                int sum = 0;
                
                // Add values from first list if available
                if (tempL1 !=null){
                    sum+=tempL1.val;
                }
                
                // Add values from second list if available
                if (tempL2 !=null){
                    sum+=tempL2.val;
                }

                // Add carry from previous sum if exists
                sum = carry != 0 ? sum + carry : sum;

                // Handle carry for current digit
                if (sum%10!=sum){
                    carry = 1;
                    sum = sum%10;  // Keep only the ones digit
                }else{
                    carry = 0;
                }
                
                // Create new node with current digit
                output.next = new ListNode(sum);
                
                // Move pointers forward
                if (tempL1 !=null){
                    tempL1 = tempL1.next;
                }
                if (tempL2 !=null){
                    tempL2 = tempL2.next;
                }
                output = output.next;
            }

            // Handle remaining carry after processing all digits
            if (carry != 0){
                output.next = new ListNode(1);
            }

            // Return result list (skip dummy head node)
            return output1.next;
        }
    }
}
