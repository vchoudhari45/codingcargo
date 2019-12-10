package com.vc.medium;

class ListNode142 {
    int val;
    ListNode142 next;
    ListNode142(int x) {
        val = x;
        next = null;
    }
}

public class L142 {
    public ListNode142 detectCycle(ListNode142 head) {
        ListNode142 hare = head;
        ListNode142 tortoise = head;
        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
            if(hare == tortoise) {
                ListNode142 start = head;
                while(start != tortoise) {
                    start = start.next;
                    tortoise = tortoise.next;
                }
                return tortoise;
            }
        }
        return null;
    }
}
