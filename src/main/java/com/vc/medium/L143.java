package com.vc.medium;

import com.vc.hard.ListNode;

class L143 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode mid = head, hare = head, tortoise = head, prev = tortoise;
        while(hare != null && hare.next != null) {
            prev = tortoise;
            tortoise = tortoise.next;
            hare = hare.next;
            hare = hare.next;
        }
        //Handle odd length
        if(hare != null) {
            hare = hare.next;
            prev = tortoise;
            tortoise = tortoise.next;
        }

        //Make them as two list
        prev.next = null;

        mid = tortoise;
        ListNode secondPart = reverse(mid);
        ListNode firstPart = head;

        ListNode res = new ListNode(-1);
        while(firstPart != null || secondPart != null) {
            if(firstPart != null) {
                res.next = firstPart;
                res = res.next;
                firstPart = firstPart.next;
            }
            if(secondPart != null) {
                res.next = secondPart;
                res = res.next;
                secondPart = secondPart.next;
            }
        }
        head = res.next;
    }

    private ListNode reverse(ListNode head) {
        /**
             dummy -> 1 -> 2 -> 3 -> 4
                p    c    n
             dummy -> 2 -> 1 -> 3 -> 4
                p         c    n
         */
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        final ListNode prev = dummyNode;
        final ListNode current = prev.next;
        ListNode next = current.next;
        while(next != null) {
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = current.next;
        }
        return dummyNode.next;
    }
}
