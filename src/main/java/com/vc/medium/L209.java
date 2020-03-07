package com.vc.medium;

class L209 {
    public int minSubArrayLen(int s, int[] arr) {
        if(arr == null || arr.length == 0) return 0;

        int end = 0, start = 0, n = arr.length;
        int runningSum = 0, min = Integer.MAX_VALUE;
        while(end < n) {
            runningSum += arr[end++];
            while(start < end && runningSum >= s) {
                min = Math.min(min, end - start);
                runningSum -= arr[start++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
