package com.vc.medium;

class L1060 {
    public int missingElement(int[] arr, int k) {
        int prev = arr[0];
        for(int i = 1; i < arr.length; i++) {
            int diff = arr[i] - prev - 1;
            if(k - diff <= 0) {
                for(int j = prev + 1; j < arr[i]; j++) {
                    k--;
                    if(k <= 0) return j;
                }
            }
            else k -= diff;
            prev = arr[i];
        }
        return prev + k;
    }
}