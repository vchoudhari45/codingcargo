package com.vc.medium;

class L81 {

    public boolean search(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(arr[mid] == target) return true;

            if(arr[lo] == arr[mid] && arr[mid] == arr[hi]) {
                lo++;
                hi--;
            }
            else if(arr[lo] <= arr[mid]) { // left part is sorted
                if(arr[lo] <= target && arr[mid] >= target) hi = mid - 1;
                else lo = mid + 1;
            }
            else {  // right part is sorted
                if(arr[mid] <= target && arr[hi] >= target) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return false;
    }
}