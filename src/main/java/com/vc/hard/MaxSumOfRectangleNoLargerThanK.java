package com.vc.hard;

import java.util.*;

class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return 0;

        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;

        int res = Integer.MIN_VALUE;
        for(int fromCol = 0; fromCol < n; fromCol++) {
            int[] colSum = new int[m];
            for(int toCol = fromCol; toCol < n; toCol++){
                for(int row = 0; row < m; row++) {
                    colSum[row] += matrix[row][toCol];
                }

                //Kadane's Algorithm to calculate max sum
                int maxSum = kadane(colSum);

                //If it is exactly K we have our answer
                if(maxSum == k) return k;

                    //Assign MaxValue if it is less than k
                else if(maxSum < k) res = Math.max(res, maxSum);

                    //Else if it is greater than k,
                else {
                    maxSum = maxSumLessThanK(colSum, k);
                    if(maxSum == k) return k;
                    else res = Math.max(res, maxSum);
                }
            }
        }

        return res;
    }

    private int kadane(int[] arr) {
        int maxSum = arr[0], currentSum = arr[0];
        for(int i = 1; i < arr.length; i++) {
            int num = arr[i];
            currentSum = Math.max(currentSum + num, num);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    private int maxSumLessThanK(int[] arr, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            Integer findNum = set.ceiling(currentSum - k);
            if(findNum != null) maxSum = Math.max(maxSum, currentSum - findNum);
            set.add(currentSum);
        }
        return maxSum;
    }
}