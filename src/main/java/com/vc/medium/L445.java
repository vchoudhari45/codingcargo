package com.vc.medium;

import com.vc.hard.ListNode;

class L445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Rev = reverse(l1);
        ListNode l2Rev = reverse(l2);

        ListNode dummyNode = new ListNode(-1);

        ListNode addition = dummyNode;
        int carry = 0;
        while(l1Rev != null && l2Rev != null) {
            int add = l1Rev.val + l2Rev.val + carry;
            int digit = add % 10;
            carry = add / 10;
            //System.out.println("digit: "+digit+" carry: "+carry);
            addition.next = new ListNode(digit);
            addition = addition.next;
            l1Rev = l1Rev.next;
            l2Rev = l2Rev.next;
        }

        while(l1Rev != null) {
            int add = l1Rev.val + carry;
            int digit = add % 10;
            carry = add / 10;
            //System.out.println("digit: "+digit+" carry: "+carry);
            addition.next = new ListNode(digit);
            addition = addition.next;
            l1Rev = l1Rev.next;
        }

        while(l2Rev != null) {
            int add = l2Rev.val + carry;
            int digit = add % 10;
            carry = add / 10;
            //System.out.println("digit: "+digit+" carry: "+carry);
            addition.next = new ListNode(digit);
            addition = addition.next;
            l2Rev = l2Rev.next;
        }

        if(carry > 0) {
            addition.next = new ListNode(carry);
            addition = addition.next;
        }

        ListNode r = reverse(dummyNode.next);
        return r;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode current = prev.next;
        ListNode next = current.next;

        while(next != null) {
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = current.next;
        }
        return prev.next;
    }
}
