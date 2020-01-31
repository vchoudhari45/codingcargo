package com.vc.medium;

import java.util.PriorityQueue;

class L215 {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
            if(pq.size() > k) pq.poll();
        }
        return pq.isEmpty() ? -1: pq.poll();
    }
}