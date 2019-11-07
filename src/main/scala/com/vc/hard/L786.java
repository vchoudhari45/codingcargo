package com.vc.hard;

import java.util.*;

class L786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int K) {
        Arrays.sort(arr);
        int x = 0, y = 0;
        double lo = 0, hi = 1;
        while(lo < hi) {
            double mid = lo + (hi - lo) / 2;
            double max = 0;
            int count = 0;
            int right = 0;
            for(int left = 0; left < arr.length; left++) {

                while(right < arr.length && arr[left] > mid * arr[right]) right++;
                count += arr.length - right;

                if(right < arr.length && arr[left] > max * arr[right]) {
                    max = (double) arr[left] / (double) arr[right];
                    x = arr[left];
                    y = arr[right];
                }
            }
            if(count > K) hi = mid;
            else if(count < K) lo = mid;
            else return new int[]{x, y};
        }
        return new int[]{x, y};
    }
}

