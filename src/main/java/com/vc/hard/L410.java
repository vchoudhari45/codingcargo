package com.vc.hard;

class L410 {
    public int splitArray(int[] arr, int m) {
        /**
            Minimize the maximum
         */
        int lo = Integer.MIN_VALUE;
        int hi = 0;
        for(int i = 0; i < arr.length; i++) {
            lo = Math.max(lo, arr[i]);
            hi += arr[i];
        }

        if(m == 1) return hi;

        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(isValid(arr, m, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private boolean isValid(int[] arr, int m, int sum) {
        int total = 0;
        int count = 1;
        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
            if(total > sum) {
                total = arr[i];
                count++;
                if(count > m) return false;
            }
        }
        return true;
    }
}