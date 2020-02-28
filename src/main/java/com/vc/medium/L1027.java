package com.vc.medium;

import java.util.*;

class L1027 {
    public int longestArithSeqLength(int[] A) {
        int n = A.length, max = 0;
        HashMap<Integer, Integer>[] arr = new HashMap[n];

        arr[0] = new HashMap<Integer, Integer>();
        for(int i = 1; i < n; i++) {
            arr[i] = new HashMap<Integer, Integer>();
            int current = A[i];
            for(int j = 0; j < i; j++) {
                int diff = current - A[j];
                arr[i].put(diff, arr[j].getOrDefault(diff, 0) + 1);
                max = Math.max(max, arr[i].get(diff));
            }
        }
        return max + 1;
    }
}
