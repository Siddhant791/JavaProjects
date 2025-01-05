package app.reverseSingleLinkedList;

//206. Reverse Linked List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode temp = null;
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}






/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode head_1 = null;

        while(curr.val != left ){
            prev = curr;
            curr = curr.next;
        }

        head_1 = curr;
        ListNode reverseLinkedList = reverseLinkedList();
        prev.next = reverseLinkedList;
        return head;
    }

    public ListNode reverseLinkedList(ListNode head, int right, ListNode head_1){
        ListNode prev = null;
        ListNode temp = null;
        ListNode curr = head;

        while(prev==null || prev.val != right ){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        head_1.next = curr;
        return prev;
    }
}