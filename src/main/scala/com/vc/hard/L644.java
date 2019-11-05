package com.vc.hard;

class L644 {
    public double findMaxAverage(int[] arr, int k) {
        double low = Integer.MAX_VALUE;
        double high = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            low = Math.min(low, arr[i]);
            high = Math.max(high, arr[i]);
        }
        while(high - low > 0.00001) {
            double mid = low + (high - low) / 2;
            if(isLarger(arr, k, mid)) low = mid;
            else high = mid;
        }
        return low;
    }

    private boolean isLarger(int[] arr, int k, double avg) {
        double a[] = new double[arr.length];
        for(int i = 0; i < a.length; i++) {
            a[i] = arr[i] - avg;
        }
        double now = 0;
        double last = 0;
        for(int i = 0; i < k; i++) now += a[i];
        if(now >= 0) return true;
        for(int i = k; i < arr.length; i++) {
            now += a[i];
            last += a[i - k];
            if(last < 0) {
                now -= last;
                last = 0;
            }
            if(now >= 0) return true;
        }
        return false;
    }
}