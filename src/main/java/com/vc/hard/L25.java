package com.vc.hard;

class L25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;

        int n = 0;
        ListNode current = head;
        while(current != null) {
            current = current.next;
            n++;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        current = prev.next;
        ListNode next = current.next;

        int i = 0;
        while(next != null) {
            i++;
            if(n < k) return dummyNode.next;
            if(i % k == 0) {
                n -= k;
                prev = current;
                current = next;
                next = current.next;
            }
            else {
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = current.next;
            }
        }
        return dummyNode.next;
    }
}
