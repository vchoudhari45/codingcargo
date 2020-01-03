package com.vc.hard;

import java.util.Arrays;

class L719 {
    public int smallestDistancePair(int[] arr, int k) {
        Arrays.sort(arr);
        int lo = 0;
        int hi = arr[arr.length - 1] - arr[0];
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(isSmaller(arr, mid, k)) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private boolean isSmaller(int[] arr, int mid, int k) {
        int count = 0;
        int left = 0;
        for(int right = 0; right < arr.length; right++) {
            while(arr[right] - arr[left] > mid) left++;
            count += right - left;
        }
        return count < k;
    }
}