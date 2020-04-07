package com.vc.hard;

class L410 {
    public int splitArray(int[] arr, int m) {
        int lo = Integer.MIN_VALUE;
        int hi = 0;
        for(int i = 0; i < arr.length; i++) {
            lo = Math.max(lo, arr[i]);
            hi += arr[i];
        }

        if(m == 1) return hi;

        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            //System.out.println(lo+" "+hi+" "+mid);
            if(madeMorePartition(arr, m, mid)) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private boolean madeMorePartition(int[] arr, int m, int sum) {
        int count = 1;
        int total = 0;
        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
            if(total > sum) {
                total = arr[i];
                count++;
                if(count > m) return true;
            }
        }
        return false;
    }
}