package com.vc.medium;

class L1031 {
    public int maxSumTwoNoOverlap(int[] arr, int L, int M) {
        int n = arr.length;
        if(n == 0) return 0;
        int[] sum = new int[n];
        sum[0] = arr[0];

        for(int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }


        int lMax = sum[L - 1];
        int mMax = sum[M - 1];
        int res = 0;
        for(int i = 0; i < n; i++) {

            if(i >= L && i + M - 1 < n) {
                res = Math.max(res, lMax + sum[i + M - 1] - sum[i - 1]);
            }

            if(i >= M && i + L - 1 < n) {
                res = Math.max(res, mMax + sum[i + L - 1] - sum[i - 1]);
            }

            if(i >= L) {
                lMax = Math.max(lMax, sum[i] - sum[i - L]);
            }

            if(i >= M) {
                mMax = Math.max(mMax, sum[i] - sum[i - M]);
            }
        }
        return res;
    }
}
