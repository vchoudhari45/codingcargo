package com.vc.hard;

import java.util.Stack;

class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;

        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') st.push(i);
            else {
                st.pop();
                if(st.empty()) st.push(i);
                else maxLength = Math.max(maxLength, i - st.peek());
            }
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}
