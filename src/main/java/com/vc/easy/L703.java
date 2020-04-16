package com.vc.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k = 0;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer e1, Integer e2) {
                return Integer.compare(e1, e2);
            }
        });
        for(int i = 0; i < nums.length; i++) pq.offer(nums[i]);
        while(pq.size() > k) pq.poll();
    }

    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k) pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
