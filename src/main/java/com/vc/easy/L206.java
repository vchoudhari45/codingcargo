package com.vc.easy;


import com.vc.hard.ListNode;

class L206 {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode current = prev.next;
        ListNode next = current.next;
        while(next != null) {
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;

            /**
                 p     c    n
                 d =>  1 -> 2 -> 3 -> 4 -> 5

                 p     n    c
                 d =>  2 -> 1 -> 3 -> 4 -> 5

                 p          c    n
                 d =>  2 -> 1 -> 3 -> 4 -> 5
             */
            next = current.next;
        }
        return prev.next;
    }
}
