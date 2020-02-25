package com.vc.hard;

import java.util.ArrayDeque;
import java.util.Deque;

class L862 {
    public int shortestSubarray(int[] arr, int K) {
        int n = arr.length;

        //Maintains start & end pointer of sliding window
        Deque<Integer> startingIndexes = new ArrayDeque<>();

        int[] prefix = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }

        int len = n + 1;
        for(int i = 0; i <= n; i++) {
            //Consider all the elements in the queue as a potential start of sliding window,
            //and see if it satisfy our K criteria
            while(startingIndexes.size() > 0
                    && prefix[i] - prefix[startingIndexes.peekFirst()] >= K) {
                len = Math.min(len, i - startingIndexes.pollFirst());
            }

            //i.e. previous element is negative and can't be start of sliding window so remove it
            while(startingIndexes.size() > 0
                    && prefix[i] <= prefix[startingIndexes.peekLast()]) {
                startingIndexes.pollLast();
            }

            startingIndexes.addLast(i);
        }
        return len == n + 1 ? -1 : len;
    }
}