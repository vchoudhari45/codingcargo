package com.vc.medium;

import com.vc.hard.ListNode;

import java.util.*;

class L1019 {
    int size = 1;
    public int[] nextLargerNodes(ListNode head) {
        if(head == null) return new int[0];

        ListNode reversed = reverse(head);
        Stack<Integer> st = new Stack<>();

        ListNode current = reversed;
        int[] res = new int[size];
        while(current != null) {
            while(!st.isEmpty() && st.peek() <= current.val) st.pop();

            if(st.isEmpty()) res[--size] = 0;
            else res[--size] = st.peek();

            st.push(current.val);
            current = current.next;
        }
        return res;
    }

    private ListNode reverse(ListNode head) {
        final ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        final ListNode prev = dummyNode;
        final ListNode current = prev.next;
        ListNode next = current.next;
        while(next != null) {
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = current.next;
            size++;
        }
        return dummyNode.next;
    }
}