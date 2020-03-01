package com.vc.medium;

class L775 {
    public boolean isIdealPermutation(int[] A) {
        if(A == null && A.length == 0) return true;

        int N = A.length;
        int floor = N;
        for (int i = N - 1; i >= 2; i--) {
            floor = Math.min(floor, A[i]);
            if (A[i - 2] > floor) return false;
        }
        return true;
    }
}
