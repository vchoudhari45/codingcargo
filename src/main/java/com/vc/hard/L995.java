package com.vc.hard;

class L995 {
    public int minKBitFlips(int[] arr, int K) {
        int n = arr.length;
        int flipped = 0;
        int[] isFlipped = new int[n];
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(i >= K) {
                flipped ^= isFlipped[i - K];
            }
            if(flipped == 0 && arr[i] == 0 || flipped == 1 && arr[i] == 1) {
                if(i + K > arr.length) return -1;
                flipped ^= 1;
                isFlipped[i] = 1;
                res++;
            }
        }
        return res;
    }
}
