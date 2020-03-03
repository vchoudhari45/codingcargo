package com.vc.medium;

class L1053 {
    public int[] prevPermOpt1(int[] A) {
        if(A == null || A.length <= 1) return A;

        int n = A.length;
        int index1 = A.length - 2;
        while(index1 >= 0 && A[index1] <= A[index1 + 1]) index1--;

        if(index1 >= 0) {

            int index = index1 + 1;
            int index2 = index;
            while(index < n && A[index] < A[index1]) {
                if(A[index] > A[index2]) {
                    index2 = index;
                }
                index++;
            }

            int swap = A[index1];
            A[index1] = A[index2];
            A[index2] = swap;
        }

        return A;
    }
}
