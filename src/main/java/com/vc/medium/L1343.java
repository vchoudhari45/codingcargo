package com.vc.medium;

class L1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        if(n < k) return 0;

        int runningSum = 0;
        for(int i = 0; i < k; i++) runningSum += arr[i];

        int res = 0;
        for(int i = k; i < n; i++) {
            if(runningSum / k >= threshold) res++;
            runningSum += arr[i];
            runningSum -= arr[i - k];
        }
        if(runningSum / k >= threshold) res++;
        return res;
    }
}
