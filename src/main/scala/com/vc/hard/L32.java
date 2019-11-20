package com.vc.hard;

import java.util.*;

class L32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<Integer>();
        int n = s.length();
        int i = 0;
        int start = 0;
        int max = 0;
        while(i < n) {
            char ch = s.charAt(i);
            if(ch == '(') st.push(i);
            else {
                if(st.isEmpty()) start = i + 1;
                else {
                    st.pop();
                    max = st.isEmpty() ? Math.max(max, i - start + 1) : Math.max(max, i - st.peek());
                }
            }
            i++;
        }
        return max;
    }
}
