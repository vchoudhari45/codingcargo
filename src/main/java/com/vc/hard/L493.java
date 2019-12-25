package com.vc.hard;

class L493 {
    int count = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums);
        return count;
    }

    private int[] mergeSort(int[] arr) {
        if(arr.length <= 1) return arr;

        int lo = 0;
        int hi = arr.length;
        int mid = lo + (hi - lo) / 2;
        int[] left = mergeSort(slice(arr, lo, mid));
        int[] right = mergeSort(slice(arr, mid, hi));

        int leftCount = 0;
        int rightCount = 0;
        while(leftCount < left.length) {
            double leftElement = left[leftCount] / 2.0;
            while(rightCount < right.length && leftElement > right[rightCount]) rightCount++;
            leftCount++;
            count += rightCount;
        }

        leftCount = 0;
        rightCount = 0;
        while(leftCount < left.length && rightCount < right.length) {
            if(left[leftCount] < right[rightCount])
                arr[leftCount + rightCount] = left[leftCount++];
            else
                arr[leftCount + rightCount] = right[rightCount++];
        }

        while(leftCount < left.length) {
            arr[leftCount + rightCount] = left[leftCount++];
        }

        while(rightCount < right.length) {
            arr[leftCount + rightCount] = right[rightCount++];
        }

        return arr;
    }

    private int[] slice(int[] arr, int from, int to) {
        if(from >= arr.length) return new int[0];
        int[] res = new int[to - from];
        int index = 0;
        for(int i = from; i < to; i++) {
            res[index++] = arr[i];
        }
        return res;
    }
}
