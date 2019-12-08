package com.vc.hard;

class ListNode25 {
    int val;
    ListNode25 next;
    ListNode25(int x) { val = x; }
}

class L25 {
    public ListNode25 reverseKGroup(ListNode25 head, int k) {
        if(head == null) return null;

        int n = 0;
        ListNode25 current = head;
        while(current != null) {
            current = current.next;
            n++;
        }

        ListNode25 dummyNode = new ListNode25(-1);
        dummyNode.next = head;

        ListNode25 prev = dummyNode;
        current = prev.next;
        ListNode25 next = current.next;

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
