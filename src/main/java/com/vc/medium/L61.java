package com.vc.medium;

import com.vc.hard.ListNode;

class L61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        ListNode tail = head;
        int size = 0;
        while(tail.next != null) {
            tail = tail.next;
            size++;
        }

        //Make it circular
        tail.next = head;

        size++;
        //Run loop k times to get to next head
        tail = head;
        int count = size - k % size - 1;
        while(count > 0) {
            tail = tail.next;
            count--;
        }

        ListNode toReturn = tail.next;
        tail.next = null;

        return toReturn;
    }
}
