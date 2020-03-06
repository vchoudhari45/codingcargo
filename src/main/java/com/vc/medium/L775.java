package com.vc.medium;

class L775 {
    public boolean isIdealPermutation(int[] A) {
        if(A == null || A.length == 0) return true;

        int n = A.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 2; j < n; j++) {
                if(A[i] > A[j]) return false;
            }
        }
        return true;
    }
}