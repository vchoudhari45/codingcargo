package com.vc.medium;

import com.vc.hard.ListNode;

class L19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode hare = dummyNode, tortoise = dummyNode;

        int index = 0;
        while(index <= n) {
            hare = hare.next;
            index++;
        }

        while(hare != null) {
            tortoise = tortoise.next;
            hare = hare.next;
        }

        tortoise.next = tortoise.next.next;
        return dummyNode.next;
    }
}
