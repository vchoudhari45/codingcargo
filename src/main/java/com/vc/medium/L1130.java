package com.vc.medium;

import java.util.*;

class L1130 {
    public int mctFromLeafValues(int[] arr) {
        if(arr == null || arr.length == 0) return 0;

        Stack<Integer> st = new Stack<>();
        st.push(Integer.MAX_VALUE);
        int res = 0;

        /**

            3 * 5 + 5 * 13 + 13 * 15 + 15 * 15

                 225
                /   \
              15    195
                   /   \
                 15    65
                      /   \
                     13   15
                         /  \
                        5   3

            15,13,5,3,15
         */
        for(int i = 0; i < arr.length; i++) {
            int next = arr[i];
            while(st.peek() <= next) {
                int mid = st.pop();
                int prev = st.peek();
                res += mid * Math.min(prev, next);
            }
            st.push(next);
        }
        while(st.size() > 2) {
            res += st.pop() * st.peek();
        }
        return res;
    }
}