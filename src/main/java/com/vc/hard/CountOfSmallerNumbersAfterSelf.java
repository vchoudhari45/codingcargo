package com.vc.hard;

import java.util.*;

class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] arr) {
        if(arr.length == 0) return new ArrayList<Integer>();
        Integer[] res = new Integer[arr.length];
        int[][] indexedArray = new int[arr.length][2];
        for(int i = 0; i < arr.length; i++) {
            indexedArray[i][0] = arr[i];
            indexedArray[i][1] = i;
            res[i] = 0;
        }
        mergeSort(indexedArray, res);
        return Arrays.asList(res);
    }

    private int[][] mergeSort(int[][] arr, Integer[] res) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid = lo + (hi - lo) / 2;

        if(lo == hi) return arr;

        int[][] left = mergeSort(slice(arr, lo, mid), res);
        int[][] right = mergeSort(slice(arr, mid + 1, hi), res);
        int l = 0;
        int r = 0;
        int leftCount = 0;

        int[][] out = new int[arr.length][2];
        int index = 0;
        while(l < left.length && r < right.length) {
            if(left[l][0] > right[r][0]) {
                out[index++] = right[r++];
                leftCount++;
            }
            else {
                out[index++] = left[l];
                int resIndex = left[l++][1];
                res[resIndex] += leftCount;
            }
        }
        while(l < left.length) {
            out[index++] = left[l];
            int resIndex = left[l++][1];
            res[resIndex] += leftCount;
        }
        while(r < right.length) {
            out[index++] = right[r++];
            leftCount++;
        }
        return out;
    }

    private int[][] slice(int[][] arr, int from, int to) {
        int[][] res = new int[to - from + 1][2];
        int index = 0;
        for(int i = from; i <= to; i++) {
            res[index++] = arr[i];
        }
        return res;
    }
}
