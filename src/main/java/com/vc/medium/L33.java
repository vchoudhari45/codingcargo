package com.vc.medium;

class L33 {

    private int[] arr;
    private int target;

    public int search(int[] arr, int target) {
        this.arr = arr;
        this.target = target;

        int minIndex = getMinIndex();

        int index = search(0, minIndex - 1);
        if(index == -1) index = search(minIndex, arr.length - 1);

        return index;
    }

    private int search(int lo, int hi) {
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] > target) hi = mid - 1;
            else if(arr[mid] < target) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    private int getMinIndex() {
        int lo = 0;
        int hi = arr.length - 1;

        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] > arr[hi]) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}