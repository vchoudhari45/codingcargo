package com.vc.hard;

import java.util.*;

class L805 {
    //https://leetcode.com/problems/split-array-with-same-average/discuss/120660/Java-accepted-recursive-solution-with-explanation
    public boolean splitArraySameAverage(int[] arr) {
        int n = arr.length;
        if(n == 1) return false;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }
        Arrays.sort(arr);
        for(int i = 1; i <= n / 2; i++) {
            if((sum * i) % n == 0) {
                if(solve(arr, (sum * i) / n, i, 0, 0)) return true;
            }
        }
        return false;
    }

    private boolean solve(int[] arr, int sum, int count, int index, int loop) {
        if(count == 0) return sum == 0;
        else {
            for(int i = index; i < arr.length; i++) {
                if(i > index && arr[i] == arr[i - 1]) continue;
                if(solve(arr, sum - arr[i], count - 1, i + 1, loop + 1)) return true;
            }
            return false;
        }
    }
}