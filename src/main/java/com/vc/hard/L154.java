package com.vc.hard;

class L154 {
    public int findMin(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] > arr[hi]) lo = mid + 1;
            else if(arr[mid] < arr[hi]) hi = mid;
            else hi--;
        }
        return arr[lo];
    }
}
