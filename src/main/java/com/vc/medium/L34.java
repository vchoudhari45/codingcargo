package com.vc.medium;

class L34 {
    public int[] searchRange(int[] arr, int target) {
        if(arr == null || arr.length == 0) return new int[]{-1, -1};

        int lo = 0, hi = arr.length - 1, n = arr.length;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        if(arr[lo] != target) return new int[]{-1, -1};
        int index = lo;
        while(index < n && arr[index] == target) index++;
        return new int[]{lo, index - 1};
    }
}