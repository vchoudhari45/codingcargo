package com.vc.medium;

import java.util.*;

class L324 {
    public void wiggleSort(int[] arr) {
        int[] copy = arr.clone();
        Arrays.sort(copy);

        int n = arr.length ;
        int lo = n % 2 == 0 ? (n / 2) - 1 : n / 2;
        int hi = n - 1;
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) arr[i] = copy[lo--];
            else arr[i] = copy[hi--];
        }
    }
}
