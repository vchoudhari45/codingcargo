package com.vc.medium;

class L209 {
    public int minSubArrayLen(int s, int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = 0;
        int min = arr.length;
        boolean found = false;
        int runningSum = 0;
        while(end < n) {
            runningSum += arr[end];
            while(runningSum >= s) {
                min = Math.min(min, end - start + 1);
                found = true;
                runningSum -= arr[start++];
            }
            end++;
        }
        return found ? min : 0;
    }
}
