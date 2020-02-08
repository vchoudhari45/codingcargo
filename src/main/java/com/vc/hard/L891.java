package com.vc.hard;

import java.util.*;

class L891 {
    public int sumSubseqWidths(int[] arr) {
        /**
             Sort the array and make subsequences

             Given Array:  2 1 3
             Sorted Array: 1 2 3

             For 1, there will be 2 ^ i subsequences which will have 1 as Max
             Subsequences 1

             And there will be 2 ^ (n - i - 1) subsequences which will have 1 as min
             Subsequences (2, 1), (1, 3)

             So add 1 to final answer 2 ^ i times
             and sub 1 from the final answer 2 ^ (n - i - 1) times
         */

        Arrays.sort(arr);
        long res = 0;
        int n = arr.length;
        int MOD = (int)1e9 + 7;

        long factor = 1;
        for(int i = 0; i < n; i++) {
            long add = (long) arr[i] * factor;
            long sub = (long) arr[n - i - 1] * factor;
            res = (res + (add - sub)) % MOD;
            factor = (factor << 1) % MOD;
        }
        return (int)res;
    }
}
