package com.vc.hard;

import java.util.*;

class L363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return 0;

        int n = matrix.length, m = matrix[0].length, max = Integer.MIN_VALUE;
        for(int fromRow = 0; fromRow < n; fromRow++) {
            int[] colSum = new int[m];
            for(int toRow = fromRow; toRow < n; toRow++) {
                for(int col = 0; col < m; col++) {
                    colSum[col] += matrix[toRow][col];
                }
                max = Math.max(max, getSum(colSum, k));
            }
        }
        return max;
    }

    private int getSum(int[] arr, int k) {
        //System.out.println(Arrays.toString(arr));
        TreeSet<Integer> set = new TreeSet();
        set.add(0);
        int currentSum = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            Integer num = set.ceiling(currentSum - k);
            if(num != null) max = Math.max(max, currentSum - num);
            set.add(currentSum);
        }
        return max;
    }
}