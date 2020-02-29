package com.vc.easy;

class L1299 {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        if(n == 0) return new int[0];

        int[] res = new int[n];
        int max = arr[n - 1];
        res[n - 1] = -1;
        for(int i = n - 2; i >= 0; i--) {
            res[i] = max;
            max = Math.max(max, arr[i]);
        }
        return res;
    }
}
