package com.vc.hard;

import java.util.*;

class L23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode list: lists) {
            if(list != null)
                pq.offer(list);
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            dummy.next = node;
            dummy = dummy.next;
            if(node.next != null)
                pq.offer(node.next);
        }
        return head.next;
    }
}
