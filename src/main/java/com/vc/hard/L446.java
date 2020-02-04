package com.vc.hard;

import java.util.HashMap;

class L446 {
    public int numberOfArithmeticSlices(int[] arr) {
        int n = arr.length;
        if(n == 0) return 0;

        int res = 0;
        HashMap<Integer, Integer>[] map = new HashMap[n];

        for(int i = 0; i < n; i++) {
            map[i] = new HashMap<Integer, Integer>(i);
            for(int j = 0; j < i; j++) {
                long diff = (long)arr[j] - arr[i];
                if(diff <= Integer.MIN_VALUE || diff >=  Integer.MAX_VALUE) continue;

                int d = (int)diff;

                int ci = map[i].getOrDefault(d, 0);
                int cj = map[j].getOrDefault(d, 0);

                res += cj;
                map[i].put(d, ci + cj + 1);
            }
        }
        return res;
    }
}
