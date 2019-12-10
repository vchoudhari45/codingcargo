package com.vc.medium;

class ListNode92 {
    int val;
    ListNode92 next;
    ListNode92(int x) { val = x; }
}

class L92 {
    public ListNode92 reverseBetween(ListNode92 head, int m, int n) {
        if(head == null) return null;

        ListNode92 dummyNode = new ListNode92(-1);
        dummyNode.next = head;

        ListNode92 prev = dummyNode;
        int i = 1;
        while(i < m) {
            prev = prev.next;
            i++;
        }

        ListNode92 current = prev.next;
        ListNode92 next = current.next;
        while(i < n && next != null) {
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;

            next = current.next;
            i++;
        }
        return dummyNode.next;
    }
}