package com.vc.medium;

class L1004 {
    public int longestOnes(int[] A, int K) {
        int start = 0, end = 0, max = 0;
        while(end < A.length) {
            if(A[end++] == 0) K--;
            while(K < 0) {
                if(A[start++] == 0) K++;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }
}