package com.vc.hard;

import java.util.*;

class L1063 {
    public int validSubarrays(int[] arr) {
        Stack<int[]> st = new Stack<>();
        int ans = 0;
        for(int i = arr.length - 1; i >= 0; i--) {
            int count = 0;
            while(!st.isEmpty() && st.peek()[0] >= arr[i]) {
                int[] e = st.pop();
                count += e[1] + 1;
            }
            ans += count + 1;
            st.push(new int[]{arr[i], count});
        }
        return ans;
    }
}
