package com.vc.easy;

class ListNode160 {
    int val;
    ListNode160 next;
    ListNode160(int x) {
        val = x;
        next = null;
    }
}

public class L160 {
    public ListNode160 getIntersectionNode(ListNode160 headA, ListNode160 headB) {
        ListNode160 currentA = headA;
        ListNode160 currentB = headB;
        while(currentA != currentB) {
            currentA = currentA == null ? headB : currentA.next;
            currentB = currentB == null ? headA : currentB.next;
        }
        return currentA;
    }
}