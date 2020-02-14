package com.vc.medium;

import java.util.Arrays;

class L31 {
    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 2;
        while(i >= 0 && arr[i] >= arr[i + 1]) i--;
        if(i >= 0) {
            int j = n - 1;
            while(arr[j] <= arr[i]) j--;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        int start = i + 1;
        Arrays.sort(arr, start, n);
    }
}