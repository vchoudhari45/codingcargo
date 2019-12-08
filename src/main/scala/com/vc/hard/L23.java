package com.vc.hard;

import java.util.*;
class ListNodeL23 {
    int val;
    ListNodeL23 next;
    ListNodeL23(int x) { val = x; }
}

class L23 {
    public ListNodeL23 mergeKLists(ListNodeL23[] lists) {
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNodeL23> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNodeL23 list: lists) {
            if(list != null)
                pq.offer(list);
        }

        ListNodeL23 dummy = new ListNodeL23(-1);
        ListNodeL23 head = dummy;
        while(!pq.isEmpty()) {
            ListNodeL23 node = pq.poll();
            dummy.next = node;
            dummy = dummy.next;
            if(node.next != null)
                pq.offer(node.next);
        }
        return head.next;
    }
}
