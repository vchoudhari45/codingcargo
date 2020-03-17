package com.vc.medium;

import com.vc.hard.ListNode;

class L2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        int carry = 0, digit = 0, total = 0;

        while(l1 != null && l2 != null) {
            total = l1.val + l2.val + carry;
            digit = total % 10;
            carry = total / 10;
            res.next = new ListNode(digit);
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            total = l1.val + carry;
            digit = total % 10;
            carry = total / 10;
            res.next = new ListNode(digit);
            res = res.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            total = l2.val + carry;
            digit = total % 10;
            carry = total / 10;
            res.next = new ListNode(digit);
            res = res.next;
            l2 = l2.next;
        }

        if(carry > 0) res.next = new ListNode(carry);

        return dummyNode.next;
    }
}
