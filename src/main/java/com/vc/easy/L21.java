package com.vc.easy;

import com.vc.hard.ListNode;

class L21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        final ListNode list = new ListNode(-1);
        ListNode res = list;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
                res = res.next;
            }
            else {
                res.next = l2;
                l2 = l2.next;
                res = res.next;
            }
        }

        while(l1 != null) {
            res.next = l1;
            l1 = l1.next;
            res = res.next;
        }

        while(l2 != null) {
            res.next = l2;
            l2 = l2.next;
            res = res.next;
        }

        return list.next;
    }
}
