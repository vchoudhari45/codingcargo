package com.vc.medium;

import com.vc.hard.ListNode;

class L147 {
    public ListNode insertionSortList(ListNode head) {
        /**
             dummyNode -> 4 -> 2 -> 1 -> 3
             dummyNode -> 2 -> 1 -> 3 -> 4
             dummyNode -> 1 -> 2 -> 3 -> 4
             dummyNode -> 1 -> 2 -> 3 -> 4

             dummyNode -> 1 -> 5 -> 3 -> 4 -> 0
             dummyNode -> 0 -> 1 -> 3 -> 4 -> 5
         */
        final ListNode dummyNode = new ListNode(-1);
        ListNode current = head;
        int size = 0;
        while(current != null) {
            current = current.next;
            size++;
        }

        dummyNode.next = head;
        for(int i = 0; i < size; i++) {
            current = dummyNode.next;
            while(current.next != null) {
                if(current.next.val < current.val) {
                    int tmp = current.val;
                    current.val = current.next.val;
                    current.next.val = tmp;
                }
                current = current.next;
            }
        }
        return head;
    }
}
