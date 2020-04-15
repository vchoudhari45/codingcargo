package com.vc.easy;

class L852 {
    public int peakIndexInMountainArray(int[] A) {
        int lo = 0;
        int hi = A.length;
        while(lo < hi) {
            int mid = lo + (hi  - lo) / 2;
            if(A[mid] < A[mid + 1]) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
