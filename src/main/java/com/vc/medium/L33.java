package com.vc.medium;

class L33 {
    public int search(int[] arr, int target) {
        if(arr.length == 0) return -1;

        int lo = 0;
        int hi = arr.length - 1;
        int minIndex = search(arr, lo, hi);
        if(arr[minIndex] == target) return minIndex;

        hi = target > arr[arr.length - 1] ? minIndex : arr.length - 1;
        lo = target <= arr[arr.length - 1] ? minIndex : 0;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] > target) {
                hi = mid - 1;
            }
            else if(arr[mid] < target) {
                lo = mid + 1;
            }
            else return mid;
        }
        return -1;
    }

    private int search(int[] arr, int lo, int hi) {
        while(lo < hi) {
            if(arr[lo] < arr[hi]) return lo;
            int mid = lo + (hi - lo) / 2;
            if(arr[lo] <= arr[mid]) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
