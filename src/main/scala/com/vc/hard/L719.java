package com.vc.hard;

import java.util.Arrays;

class L719 {
    public int smallestDistancePair(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int lo = 0;
        int hi = arr[n - 1] - arr[0];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            int left = 0;
            for (int right = 0; right < n; right++) {
                while (arr[right] - arr[left] > mid) left++;
                count += right - left;
            }
            if (count >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}