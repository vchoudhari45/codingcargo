package com.vc.medium;

class L1014 {
    public int maxScoreSightseeingPair(int[] A) {
        if(A == null || A.length == 0) return 0;

        int n = A.length, max = 0;

        int prev = max = A[0];
        for(int i = 1; i < n; i++) {
            int newPrev = Math.max(A[i], prev - 1);
            max = Math.max(max, prev - 1 + A[i]);
            prev = newPrev;
        }
        return max;
    }
}
