package com.vc.medium;

import java.util.*;

class L368 {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        int n = arr.length;
        if(n == 0) return new ArrayList<Integer>();

        int[] dp = new int[n];
        Arrays.sort(arr);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] % arr[j] == 0)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int maxIndex = 0;
        int max = 0;
        for(int i = 0; i < dp.length; i++) {
            if(max < dp[i]) {
                max = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        res.add(arr[maxIndex]);
        for(int i = maxIndex; i >= 0; i--){
            if(dp[i] + 1 == dp[maxIndex]) {
                maxIndex = i;
                res.add(arr[maxIndex]);
            }
        }

        return res;
    }
}
