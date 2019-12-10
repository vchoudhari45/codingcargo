package com.vc.medium;

import java.util.*;

//https://www.youtube.com/watch?v=KAZM4tsH8aI
class L528 {

    int[] wSum;
    Random r;
    int len;

    public L528(int[] w) {
        len = w.length;
        r = new Random();
        for(int i = 1; i < len; i++) {
            w[i] += w[i - 1];
        }
        this.wSum = w;
    }

    public int pickIndex() {
        int randomSum = r.nextInt(wSum[len - 1]);
        int lo = 0;
        int hi = len - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(wSum[mid] <= randomSum) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
