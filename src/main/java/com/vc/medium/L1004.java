package com.vc.medium;

class L1004 {
    public int longestOnes(int[] A, int K) {
        int start = 0, end = 0, n = A.length, window = 0;
        while(end < n) {
            if(A[end] == 0) {
                K--;
                while(K < 0) {
                    if(A[start] == 0) K++;
                    start++;
                }
            }
            window = Math.max(window, end - start + 1);
            end++;
        }
        return window;
    }
}
