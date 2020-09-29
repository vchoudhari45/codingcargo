package com.vc.hard;

import java.util.*;

class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        if(n + m == k) return merge(nums1, nums2);
        int[] res1 = helper(nums1, nums2, k);
        int[] res2 = helper(nums2, nums1, k);
        return compareArray(res1, res2, 0, 0) ? res1 : res2;
    }

    private int[] helper(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for(int i = 0; i < Math.min(k, nums1.length); i++) {
            int fromArr1 = i;
            int fromArr2 = k - i;

            if(fromArr2 > nums2.length) continue;

            int[] arr1 = maxArray(nums1, fromArr1);
            int[] arr2 = maxArray(nums2, fromArr2);

            int[] maxArr = merge(arr1, arr2);
            boolean isBigger = compareArray(maxArr, res, 0, 0);
            if(isBigger) res = maxArr;
        }
        return res;
    }


    private int[] maxArray(int[] arr, int k) {
        int[] res = new int[k];
        if(k == 0) return res;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            while(!st.isEmpty() && st.peek() < arr[i] && arr.length - i + st.size() > k) {
                st.pop();
            }
            if(st.size() < k) st.push(arr[i]);
        }
        while(!st.isEmpty()) res[--k] = st.pop();
        return res;
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int i = 0, j = 0;
        int[] res = new int[n + m];
        while(i < n && j < m) {
            boolean isBigger = compareArray(arr1, arr2, i, j);
            if(isBigger) res[i + j] = arr1[i++];
            else res[i + j] = arr2[j++];
        }
        while(i < n) res[i + j] = arr1[i++];
        while(j < m) res[i + j] = arr2[j++];
        return res;
    }

    private boolean compareArray(int[] res1, int[] res2, int i, int j) {
        if(i >= res1.length) return false;
        else if(j >= res2.length) return true;
        else if(res1[i] > res2[j]) return true;
        else if(res1[i] < res2[j]) return false;
        else return compareArray(res1, res2, i + 1, j + 1);
    }
}