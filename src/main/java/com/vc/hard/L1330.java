package com.vc.hard;

class L1330 {
    public int maxValueAfterReverse(int[] arr) {
        //https://leetcode.com/problems/reverse-subarray-to-maximize-array-value/discuss/490208/JavaScript-O(n)-Time-O(1)-Space-wexplanation
        int n = arr.length;
        int sum = 0;

        int improvement = 0;
        for(int i = 1; i < n; i++) {
            int right = arr[i], left = arr[i - 1];

            //Diff in current pair
            int diff = Math.abs(right - left);

            //Total as of now
            sum += diff;

            //improvement if we reverse from 0 to i
            int improvementFirst = Math.abs(arr[0] - right) - diff;

            //improvement if we reverse from i to n - 1
            int improvementSecond = Math.abs(arr[n - 1] - left) - diff;

            improvement = Math.max(improvementFirst, improvement);
            improvement = Math.max(improvementSecond, improvement);
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++) {
            int currentMin = Math.min(arr[i], arr[i - 1]);
            int currentMax = Math.max(arr[i], arr[i - 1]);

            min = Math.min(currentMax, min);
            max = Math.max(currentMin, max);
        }
        improvement = Math.max(improvement, 2 * (max - min));

        return sum + improvement;
    }
}
