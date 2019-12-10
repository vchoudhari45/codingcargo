package com.vc.hard;

import java.util.*;

class L45 {
    public int jump(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        for(int i = 0; i < n - 1; i++) {
            int k = 1;
            while(k <= arr[i] && k + i < n) {
                res[k + i] = res[i] == Integer.MAX_VALUE ? 1 : Math.min(res[k + i], res[i] + 1);
                k++;
            }
        }
        res[0] = 0;
        return res[n - 1];
    }
}
