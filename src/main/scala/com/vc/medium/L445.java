package com.vc.medium;

class ListNode445 {
    int val;
    ListNode445 next;
    ListNode445(int x) { val = x; }
}

class L445 {
    public ListNode445 addTwoNumbers(ListNode445 l1, ListNode445 l2) {
        ListNode445 l1Rev = reverse(l1);
        ListNode445 l2Rev = reverse(l2);

        ListNode445 dummyNode = new ListNode445(-1);

        ListNode445 addition = dummyNode;
        int carry = 0;
        while(l1Rev != null && l2Rev != null) {
            int add = l1Rev.val + l2Rev.val + carry;
            int digit = add % 10;
            carry = add / 10;
            //System.out.println("digit: "+digit+" carry: "+carry);
            addition.next = new ListNode445(digit);
            addition = addition.next;
            l1Rev = l1Rev.next;
            l2Rev = l2Rev.next;
        }

        while(l1Rev != null) {
            int add = l1Rev.val + carry;
            int digit = add % 10;
            carry = add / 10;
            //System.out.println("digit: "+digit+" carry: "+carry);
            addition.next = new ListNode445(digit);
            addition = addition.next;
            l1Rev = l1Rev.next;
        }

        while(l2Rev != null) {
            int add = l2Rev.val + carry;
            int digit = add % 10;
            carry = add / 10;
            //System.out.println("digit: "+digit+" carry: "+carry);
            addition.next = new ListNode445(digit);
            addition = addition.next;
            l2Rev = l2Rev.next;
        }

        if(carry > 0) {
            addition.next = new ListNode445(carry);
            addition = addition.next;
        }

        ListNode445 r = reverse(dummyNode.next);
        return r;
    }

    private ListNode445 reverse(ListNode445 head) {
        ListNode445 prev = new ListNode445(-1);
        prev.next = head;
        ListNode445 current = prev.next;
        ListNode445 next = current.next;

        while(next != null) {
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = current.next;
        }
        return prev.next;
    }
}
