package com.vc.medium;

class L162 {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for(int i = 1; i < n; i++) {
            if(arr[i - 1] < arr[i]) left[i] = 1;
        }

        right[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--) {
            if(arr[i + 1] < arr[i]) right[i] = 1;
        }

        for(int i = 0; i < left.length; i++) {
            if(left[i] + right[i] == 2) return i;
        }
        return -1;
    }
}
