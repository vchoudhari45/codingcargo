package com.vc.easy;

import java.util.Stack;

class L20 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                if(st.isEmpty() || st.pop() != '(') return false;
            }
            else if(s.charAt(i) == ']') {
                if(st.isEmpty() || st.pop() != '[') return false;
            }
            else if(s.charAt(i) == '}') {
                if(st.isEmpty() || st.pop() != '{') return false;
            }
            else st.push(s.charAt(i));
        }
        return st.size() == 0;
    }
}
