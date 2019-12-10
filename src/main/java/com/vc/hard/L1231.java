package com.vc.hard;

class L1231 {
    public int maximizeSweetness(int[] arr, int k) {
        /**
         Maximize the minimum
         */
        k++;
        int lo = Integer.MAX_VALUE;
        int hi = 0;
        for(int i = 0; i < arr.length; i++) {
            lo = Math.min(lo, arr[i]);
            hi += arr[i];
        }

        while(lo < hi) {
            int mid = (lo + hi + 1) / 2;
            boolean isPossible = isPossible(arr, mid, k);
            //System.out.println("lo: "+lo+" hi: "+hi+" mid: "+mid+" "+isPossible);
            if(isPossible) hi = mid - 1;
            else lo = mid;
        }
        return lo;
    }

    private boolean isPossible(int[] arr, int mid, int k) {
        int total = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
            if(total >= mid) {
                total = 0;
                count++;
            }
        }
        return count < k;
    }
}