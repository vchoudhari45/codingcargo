package com.vc.hard;

class L810 {
    public boolean xorGame(int[] arr) {
        int xor = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            xor ^= arr[i];
        }
        return xor == 0 || arr.length % 2 == 0;
    }
}
