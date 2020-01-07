package com.vc.hard;

class L786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int K) {
        double lo = 0;
        double hi = 1;

        int[] res = new int[2];
        while(lo < hi) {
            double mid = lo + (hi - lo) / 2;
            int count = countFractions(arr, mid, res);
            if(count < K) lo = mid;
            else if(count > K) hi = mid;
            else return res;
        }
        return res;
    }

    private int countFractions(int[] arr, double mid, int[] res) {
        int right = 0;
        int count = 0;
        double ans = 0;
        for(int left = 0; left < arr.length; left++) {
            while(right < arr.length && arr[left] > mid * arr[right]) right++;
            count += arr.length - right;

            if(right < arr.length && arr[left] > ans * arr[right]) {
                ans = (double) arr[left] / (double) arr[right];
                res[0] = arr[left];
                res[1] = arr[right];
            }
        }
        return count;
    }
}