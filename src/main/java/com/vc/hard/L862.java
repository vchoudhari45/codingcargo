package com.vc.hard;

import java.util.ArrayDeque;
import java.util.Deque;

class L862 {
    public int shortestSubarray(int[] arr, int K) {
        int n = arr.length;

        int[] prefixSum = new int[n + 1];
        for(int i = 1; i < prefixSum.length; i++) prefixSum[i] += prefixSum[i - 1] + arr[i - 1];

        //Maintains start & end pointer of sliding window
        Deque<Integer> d = new ArrayDeque<>();

        int res = n + 1;
        for(int i = 0; i < arr.length + 1; i++) {

            //Consider all the elements in the queue as a potential start of sliding window,
            //and see if it satisfy our K criteria
            while(d.size() > 0 && prefixSum[i] - prefixSum[d.getFirst()] >= K) {
                res = Math.min(res, i - d.pollFirst());
            }

            //i.e. previous element is negative and can't be start of sliding window so remove it
            while(d.size() > 0 && prefixSum[i] <= prefixSum[d.getLast()]) {
                d.pollLast();
            }

            d.addLast(i);
        }
        return res == n + 1 ? -1 : res;
    }
}
