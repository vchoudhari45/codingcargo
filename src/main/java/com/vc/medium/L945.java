package com.vc.medium;

import java.util.Arrays;

class L945 {
    public int minIncrementForUnique(int[] A) {
        if(A == null || A.length == 0) return 0;

        Arrays.sort(A);
        int next, moves = 0, prev = A[0];
        for(int i = 1; i < A.length; i++) {
            next = prev + 1;
            moves += A[i] > next ? 0 : next - A[i];
            prev = Math.max(next, A[i]);
        }
        return moves;
    }
}
