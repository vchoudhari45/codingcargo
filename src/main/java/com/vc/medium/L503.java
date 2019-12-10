package com.vc.medium;

import java.util.*;

class L503 {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();
        solve(arr, res, st);
        solve(arr, res, st);
        return res;
    }

    private void solve(int[] arr, int res[], Stack<Integer> st) {
        for(int i = 0; i < arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] < arr[i]) res[st.pop()] = arr[i];
            st.push(i);
        }
    }
}