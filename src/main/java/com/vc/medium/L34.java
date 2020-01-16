package com.vc.medium;

class L34 {
    public int[] searchRange(int[] arr, int target) {
        int lo = findFirst(arr, target);
        int hi = findLast(arr, target);
        return new int[] {hi, lo};
    }

    private int findFirst(int[] arr, int target) {
        int index = -1;
        int lo = 0;
        int hi = arr.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] > target) hi = mid - 1;
            else lo = mid + 1;
            if(arr[mid] == target) index = mid;
        }
        return index;
    }

    private int findLast(int[] arr, int target) {
        int index = -1;
        int lo = 0;
        int hi = arr.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] < target) lo = mid + 1;
            else hi = mid - 1;
            if(arr[mid] == target) index = mid;
        }
        return index;
    }
}
