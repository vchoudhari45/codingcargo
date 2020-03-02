package com.vc.medium;

import java.util.Arrays;

class L280 {
    public void wiggleSort(int[] arr) {
        if(arr == null || arr.length == 0) return;

        int n = arr.length;
        Arrays.sort(arr);
        for(int i = 1; i + 1 < n; i++) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
}
