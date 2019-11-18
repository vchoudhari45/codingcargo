package com.vc.hard;

class L1231 {
    public int maximizeSweetness(int[] arr, int k) {
        k++;
        int lo = Integer.MAX_VALUE;
        int hi = 0;
        for(int i = 0; i < arr.length; i++) {
            lo = Math.min(lo, arr[i]);
            hi += arr[i];
        }

        /**
         In this question, we want to find the maximum total sweetness.
         We have to find the rightmost value,
         so we use int mid = (left + right + 1)/2 and if(condition passed)
         left = mid;else hi = mid - 1.

         For question like 1101,
         we want to find the leftmost value.
         so we have to use something like int mid = (left + right) / 2 and if(condition passed)
         right = mid; else left = mid + 1;
         */
        while(lo < hi) {
            int mid = (lo + hi + 1) / 2;
            int parts = getParts(arr, mid);
            if(parts < k) hi = mid - 1;
            else lo = mid;
        }
        return lo;
    }

    private int getParts(int[] arr, int sum) {
        int total = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
            if(total >= sum) {
                total = 0;
                count++;
            }
        }
        return count;
    }
}