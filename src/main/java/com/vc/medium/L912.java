package com.vc.medium;

import java.util.*;

class L912 {
    public List<Integer> sortArray(int[] arr) {
        int[] a = mergeSort(arr);
        List<Integer> res = new ArrayList<>();
        for (int value : a) res.add(value);
        return res;
    }

    private int[] mergeSort(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;

        if(lo >= hi) return arr;

        int mid = lo + (hi - lo) / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, lo, mid + 1));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid + 1, hi + 1));

        int l = 0, r = 0, index = 0;
        int[] res = new int[arr.length];
        while(l < left.length && r < right.length) {
            if(left[l] < right[r]) res[index++] = left[l++];
            else res[index++] = right[r++];
        }

        while(l < left.length) res[index++] = left[l++];
        while(r < right.length) res[index++] = right[r++];

        return res;
    }
}
