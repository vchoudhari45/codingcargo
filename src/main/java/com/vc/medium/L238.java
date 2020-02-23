package com.vc.medium;

class L238 {
    public int[] productExceptSelf(int[] arr) {
        int n = arr.length;

        if(n == 0) return new int[0];

        int[] res = new int[n];
        res[0] = 1;
        int runningPrefix = arr[0];
        for(int i = 1; i < n; i++) {
            res[i] = runningPrefix;
            runningPrefix *= arr[i];
        }

        int runningSuffix = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            res[i] *= runningSuffix;
            runningSuffix *= arr[i];
        }

        return res;
    }
}
