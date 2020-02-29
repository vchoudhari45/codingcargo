package com.vc.medium;

class L915 {
    public int partitionDisjoint(int[] A) {
        if(A == null || A.length <= 1) return 0;

        int n = A.length;
        int[] minRight = new int[n];
        int min = minRight[n - 1] = A[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            min = minRight[i] = Math.min(A[i], min);
        }

        int max = A[0];
        for(int i = 1; i < n; i++) {
            if(max <= minRight[i]) return i;
            max = Math.max(max, A[i]);
        }
        return 1;
    }
}
