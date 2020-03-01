package com.vc.hard;

import java.util.*;

class L1074 {

    private int target = 0;

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0) return 0;

        int m = matrix[0].length;
        if(m == 0) return 0;

        this.target = target;

        int res = 0;
        for(int startCol = 0; startCol < m; startCol++) {
            int[] arr = new int[n];
            for(int endCol = startCol; endCol < m; endCol++) {
                for(int row = 0; row < n; row++) {
                    arr[row] += matrix[row][endCol];
                }
                res += subArraySum(arr);
            }
        }
        return res;
    }

    private int subArraySum(int[] arr) {
        //[4, 1, 5]
        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        int count = 0;
        int runningSum = 0;
        for(int i = 0; i < arr.length; i++) {
            runningSum += arr[i];
            if(prefix.containsKey(runningSum - target)) {
                count += prefix.get(runningSum - target);
            }
            prefix.put(runningSum, prefix.getOrDefault(runningSum, 0) + 1);
        }
        return count;
    }
}
