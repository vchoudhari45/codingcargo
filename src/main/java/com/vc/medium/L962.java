package com.vc.medium;

import java.util.*;

class L962 {
    public int maxWidthRamp(int[] arr) {
        int n = arr.length;
        if(n == 0) return 0;

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            if(st.isEmpty() || arr[st.peek()] > arr[i]) st.add(i);
        }

        int res = 0;
        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                res = Math.max(res, i - st.pop());
            }
        }
        return res;
    }
}
