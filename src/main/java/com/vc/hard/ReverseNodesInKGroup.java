package com.vc.hard;

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
class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;

        //Count total number of elements in an input list
        int total = 0;
        ListNode current = head;
        while(current != null) {
            current = current.next;
            total++;
        }

        final ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        current = prev.next;
        ListNode next = current.next;

        int i = 1;
        while(next != null) {

            //If number remaining element in an input list is less than number of element required to make a group to reverse then return the answer.
            if(total < k) return dummyNode.next;


            //When current element i completes a group our logic should stop reversing elements in a current group
            if(i % k == 0) {
                total -= k;
                prev = current;
                current = next;
                next = next.next;
            }
            else {
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = current.next;
            }
            i++;
        }
        return dummyNode.next;
    }
}