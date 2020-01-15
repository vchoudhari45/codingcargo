package com.vc.medium;

class L153 {
    public int findMin(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while(lo < hi) {
            if(arr[lo] < arr[hi]) return arr[lo];

            int mid = lo + (hi - lo) / 2;
            if(arr[mid] >= arr[lo]) lo = mid + 1;
            else hi = mid;
        }
        return arr[lo];
    }
}
