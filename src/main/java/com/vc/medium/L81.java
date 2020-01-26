package com.vc.medium;

class L81 {
    public boolean search(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] == target) return true;

            if(arr[lo] == arr[mid] && arr[hi] == arr[mid]) {
                lo++;
                hi--;
            }
            else if(arr[lo] <= arr[mid]) {
                if(arr[lo] <= target && arr[mid] > target) hi = mid - 1;
                else lo = mid + 1;
            }
            else {
                if(arr[mid] < target && arr[hi] >= target) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return false;
    }
}
