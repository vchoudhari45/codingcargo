package com.vc.hard;

import java.util.*;

class L321 {
    public int[] maxNumber(int[] arr1, int[] arr2, int k) {
        /**
         arr1 = [3, 4, 6, 5]
         arr2 = [9, 1, 2, 5, 8, 3]
         */
        if(arr1.length + arr2.length == k) return merge(arr1, arr2);
        int[] arr1Solve = solve(arr1, arr2, k);
        int[] arr2Solve = solve(arr2, arr1, k);
        return compareArray(arr1Solve, arr2Solve, 0, 0) ? arr1Solve : arr2Solve;
    }

    private int[] solve(int[] arr1, int[] arr2, int k) {
        int[] res = new int[k];
        for(int i = 0; i < Math.min(k, arr1.length); i++) {
            int fromArr1 = i;
            int fromArr2 = k - i;
            if(arr2.length < fromArr2) continue;
            int[] maxArray1 = maxArray(arr1, fromArr1);
            int[] maxArray2 = maxArray(arr2, fromArr2);
            int[] mergeArray = merge(maxArray1, maxArray2);
            boolean isBigger = compareArray(mergeArray, res, 0, 0);
            if(isBigger) res = mergeArray;
        }
        return res;
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] res = new int[n + m];
        int i = 0;
        int j = 0;
        int index = 0;
        while(i < n && j < m) {
            boolean compare = compareArray(arr1, arr2, i, j);
            if(compare) res[index++] = arr1[i++];
            else res[index++] = arr2[j++];
        }
        while(i < n) res[index++] = arr1[i++];
        while(j < m) res[index++] = arr2[j++];
        return res;
    }

    private boolean compareArray(int[] arr1, int[] arr2, int i, int j) {
        if(arr1.length <= i) return false;
        else if(arr2.length <= j) return true;
        else if(arr1[i] > arr2[j]) return true;
        else if(arr1[i] < arr2[j]) return false;
        else return compareArray(arr1, arr2, i + 1, j + 1);
    }

    private int[] maxArray(int[] arr, int k) {
        //[9, 1, 2, 5, 8, 3]
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            while(st.size() + arr.length - i > k && !st.isEmpty() && st.peek() < arr[i]) {
                st.pop();
            }
            if(st.size() < k) st.push(arr[i]);
        }
        int[] res = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}

