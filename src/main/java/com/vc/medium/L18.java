package com.vc.medium;

import java.util.*;

class L18 {

    private int[] arr;

    public List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if(arr == null || arr.length == 0) return res;

        this.arr = arr;
        Arrays.sort(arr);
        int n = arr.length;
        HashSet<String> duplicates = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    int a = arr[i], b = arr[j], c = arr[k];
                    int dIndex = findIndex(target - a - b - c, k + 1, n - 1);
                    if(dIndex != -1 && !duplicates.contains(a+" "+b+" "+c+" "+arr[dIndex])) {
                        duplicates.add(a+" "+b+" "+c+" "+arr[dIndex]);
                        res.add(Arrays.asList(a, b, c, arr[dIndex]));
                    }
                }
            }
        }
        return res;
    }

    private int findIndex(int target, int lo, int hi) {
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] > target) {
                hi = mid - 1;
            }
            else if(arr[mid] < target) {
                lo = mid + 1;
            }
            else return mid;
        }
        return -1;
    }
}
