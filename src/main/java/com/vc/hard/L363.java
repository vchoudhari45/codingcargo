package com.vc.hard;

import java.util.*;

class L363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        /**
             [
                [1, 0,1],
                [0,-2,3]
             ]
         */
        int rn = matrix.length;
        if(rn == 0) return 0;
        int cn = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for(int c1 = 0; c1 < cn; c1++) {
            int[] c = new int[rn];
            for(int c2 = c1; c2 < cn; c2++) {
                for(int r = 0; r < rn; r++) {
                    c[r] += matrix[r][c2];
                }
                max = Math.max(max, maxArray(c, k));
            }
        }
        return max;
    }

    private int maxArray(int[] arr, int k) {
        //System.out.println("\nArray: ");
        //for(int i = 0; i < arr.length; i++) System.out.print(arr[i]+" ");

        TreeSet<Integer> sum = new TreeSet<>();
        sum.add(0);
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        for(int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            Integer num = sum.ceiling(curSum - k);
            if(num != null) max = Math.max(max, curSum - num);
            sum.add(curSum);
        }
        return max;
    }
}