package com.vc.hard;

import java.util.*;

class L363 {
    public int maxSumSubmatrix(int[][] arr, int k) {
        if(arr == null || arr.length == 0) return 0;
        int rn = arr.length;
        int cn = arr[0].length;
        int max = Integer.MIN_VALUE;
        for(int c1 = 0; c1 < cn; c1++) {
            int[] colSum = new int[rn];
            for(int c2 = c1; c2 < cn; c2++) {
                for(int row = 0; row < rn; row++) {
                    colSum[row] += arr[row][c2];
                }
                max = Math.max(max, maxSumSubArray(colSum, k));
            }
        }
        return max;
    }

    private int maxSumSubArray(int[] arr, int k) {
        TreeSet<Integer> sums = new TreeSet<Integer>();
        sums.add(0);
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        for(int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            Integer num = sums.ceiling(curSum - k);
            if(num != null) max = Math.max(max, curSum - num);
            sums.add(curSum);
        }
        return max;
    }
}
