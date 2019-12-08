package com.vc.easy;

class ListNode206 {
    int val;
    ListNode206 next;
    ListNode206(int x) { val = x; }
}

class Solution {
    public ListNode206 reverseList(ListNode206 head) {
        if(head == null) return null;

        ListNode206 prev = new ListNode206(-1);
        prev.next = head;
        ListNode206 current = prev.next;
        ListNode206 next = current.next;
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
