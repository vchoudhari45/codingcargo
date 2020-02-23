package com.vc.medium;

class L311 {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A.length == 0 || B.length == 0) return new int[A.length][B.length];

        int[][] res = new int[A.length][B[0].length];
        for(int row = 0; row < A.length; row++) {
            for(int col = 0; col < B[0].length; col++) {
                for(int common = 0; common < B.length; common++) {
                    res[row][col] += A[row][common] * B[common][col];
                }
            }
        }
        return res;
    }
}