package com.vc.easy;

class L643 {
    public double findMaxAverage(int[] arr, int k) {
        int i = 0;
        double sum = 0;
        while(i < k) {
            sum += arr[i++];
        }

        double maxAvg = sum / k;
        while(i < arr.length) {
            sum -= arr[i - k];
            sum += arr[i++];
            maxAvg = Math.max(maxAvg, sum / k);
        }
        return maxAvg;
    }
}
