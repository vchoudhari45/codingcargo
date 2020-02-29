package com.vc.medium;

class L795 {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return count(A, R) - count(A, L - 1);
    }

    private int count(int[] A, int bound) {
        int prev = 0, res = 0;
        for(int i = 0; i < A.length; i++) {
            prev = A[i] <= bound ? prev + 1 : 0;
            res += prev;
        }
        return res;
    }
}
