package com.vc.medium;

import java.util.*;

class ListNode1019 {
    int val;
    ListNode1019 next;
    ListNode1019(int x) { val = x; }
}

class IndexedListNode1019 {
    ListNode1019 listNode;
    int index;

    IndexedListNode1019(ListNode1019 l, int i) {
        listNode = l;
        index = i;
    }
}
class L1019 {
    public int[] nextLargerNodes(ListNode1019 head) {
        ListNode1019 current = head;
        int size = 0;
        while(current != null) {
            current = current.next;
            size++;
        }

        int[] res = new int[size];
        Stack<IndexedListNode1019> st = new Stack<IndexedListNode1019>();
        current = head;
        int i = 0;
        while(current != null) {
            IndexedListNode1019 indexedListNode = new IndexedListNode1019(current, i++);
            while(!st.isEmpty() && st.peek().listNode.val < current.val) {
                IndexedListNode1019 pop = st.pop();
                res[pop.index] = current.val;
            }
            st.push(indexedListNode);
            current = current.next;
        }
        return res;
    }
}
