package com.vc.medium;

class L775 {
    public boolean isIdealPermutation(int[] A) {
        if(A == null && A.length == 0) return true;

        int N = A.length;
        for (int i = 0; i < N; ++i)
            for (int j = i + 2; j < N; ++j)
                if (A[i] > A[j]) return false;
        return true;
    }
}
