package com.vc.medium;

import java.util.*;

class L120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] arr = new int[n + 1];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                arr[j] = Math.min(arr[j], arr[j + 1]) + triangle.get(i).get(j);
            }
        }
        return arr[0];
    }
}
