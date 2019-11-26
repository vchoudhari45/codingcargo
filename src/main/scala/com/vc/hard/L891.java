package com.vc.hard;

import java.util.*;

class L891 {
    public int sumSubseqWidths(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        long res = 0;
        long factor = 1;
        long MOD = (long)1e9 + 7;
        for(int i = 0; i < n; i++) {
            long add = arr[i] * factor;
            long sub = arr[n - i - 1] * factor;
            res = (res + add - sub) % MOD;
            factor = (factor << 1) % MOD;
        }
        return (int)(res % MOD);
    }
}
