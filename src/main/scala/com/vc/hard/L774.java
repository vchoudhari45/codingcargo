package com.vc.hard;

class Solution {
    public double minmaxGasDist(int[] arr, int K) {
        double lo = 0;
        double hi = arr[arr.length - 1] - arr[0];
        /**
         Minimize the maximum
         */
        while(lo + 1e-6 < hi) {
            double mid = lo + (hi - lo) / 2;
            boolean isPossible = isPossible(arr, mid, K);
            //System.out.println("lo: "+lo+" hi: "+hi+" Mid: "+mid+" isPossible: "+isPossible);
            if(!isPossible) lo = mid + 1e-6;
            else hi = mid;
        }
        return lo;
    }

    private boolean isPossible(int[] arr, double mid, int k) {
        int count = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            count += Math.ceil((arr[i + 1] - arr[i]) / mid) - 1;
            if(count > k) return false;
        }
        return true;
    }
}