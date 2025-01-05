package app.reverseSingleLinkedList;

//92. Reverse Linked List II
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

        if(left == right){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode head_1 = null;

        for(int i=0; i<left-1;i++){
            prev = curr;
            curr = curr.next;
        }

        head_1 = curr;
        ListNode reverseLinkedList = reverseLinkedList(curr,left,right,head_1);
        if(prev!=null){
            prev.next = reverseLinkedList;
        }
        else{
            head = reverseLinkedList;
        }
        return head;
    }

    public ListNode reverseLinkedList(ListNode head, int left,int right ,ListNode head_1){
        ListNode prev = null;
        ListNode temp = null;
        ListNode curr = head;

        for(int i=0;i<right-left+1;i++){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        head_1.next = curr;
        return prev;
    }
}