package com.vc.hard;

class L774 {
    public double minmaxGasDist(int[] stations, int K) {
        int n = stations.length;
        if(n == 0) return 0d;

        double lo = 0;
        double hi = stations[n - 1] - stations[0];

        while(lo + 1e-6 < hi) {
            double mid = lo + (hi - lo) / 2;
            //System.out.println("mid: "+mid+" lo: "+lo+" hi: "+hi);
            if(isSmaller(stations, mid, K)) lo = mid;
            else hi = mid;
        }
        return lo;
    }

    private boolean isSmaller(int[] arr, double distance, int k) {
        int count = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            count += Math.floor((arr[i + 1] - arr[i]) / distance);
            if(count > k) return true;
        }
        return false;
    }
}