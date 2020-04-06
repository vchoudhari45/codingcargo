package com.vc.medium;

class L338 {
    public int[] countBits(int num) {
        /**
            x = x / 2 + x % 2;
         */
        int[] res = new int[num + 1];
        res[0] = 0;
        for(int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
