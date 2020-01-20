package com.vc.medium;

class L813 {
    public double largestSumOfAverages(int[] arr, int K) {
        double[][] memo = new double[arr.length + 1][K + 1];
        return solve(arr, 0, K, memo);
    }

    private double solve(int[] arr, int index, int k, double[][] memo) {
        if(memo[index][k] > 0) return memo[index][k];
        if(index == arr.length) return 0;
        if(k == 1) {
            int current = 0;
            for(int i = index; i < arr.length; i++) current += arr[i];
            double res = (double) current / (double) (arr.length - index);
            memo[index][k] = res;
            return res;
        }
        double res = 0;
        int current = 0;
        for(int i = index; i < arr.length; i++) {
            current += arr[i];
            double avg = (double) current / (double) (i - index + 1);
            double sub = solve(arr, i + 1, k - 1, memo);
            memo[i + 1][k - 1] = sub;
            res = Math.max(res, avg + sub);
        }
        memo[index][k] = res;
        return res;
    }
}