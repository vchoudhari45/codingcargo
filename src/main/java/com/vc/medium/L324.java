package com.vc.medium;

import java.util.*;

class L324 {
    public void wiggleSort(int[] arr) {
        int[] copy = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(copy);

        int n = arr.length;
        int left = (n + 1) / 2 - 1;
        int right = n - 1;
        for(int i = 0; i < arr.length; i++) {
            if(i % 2 == 1) {
                arr[i] = copy[right];
                right--;
            }
            else {
                arr[i] = copy[left];
                left--;
            }
        }
    }
}
