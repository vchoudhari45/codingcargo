package com.vc.easy;

class ListNode141 {
    int val;
    ListNode141 next;
    ListNode141(int x) {
        val = x;
        next = null;
    }
}

public class L141 {
    public boolean hasCycle(ListNode141 head) {
        if(head == null) return false;
        ListNode141 hare = head;
        ListNode141 tortoize = head;
        while(hare != null && hare.next != null) {
            hare = hare.next;
            hare = hare.next;
            tortoize = tortoize.next;
            if(hare == tortoize) return true;
        }
        return false;
    }
}