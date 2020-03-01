package com.vc.medium;

class L918 {
    public int maxSubarraySumCircular(int[] A) {
        if(A == null && A.length == 0) return 0;

        int minSum = 0, maxSum = 0, sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            minSum += A[i];
            maxSum += A[i];

            min = Math.min(minSum, min);
            max = Math.max(maxSum, max);

            if(minSum > 0) minSum = 0;
            if(maxSum < 0) maxSum = 0;
        }
        if(max < 0) return max;
        max = Math.max(max, sum - min);
        return max;
    }
}
