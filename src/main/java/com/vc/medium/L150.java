package com.vc.medium;

import java.util.*;

class L150 {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if(isNumber(s.charAt(0)) ||
                    (s.charAt(0) == '-' && s.length() > 1 && isNumber(s.charAt(1)))) {
                st.push(Integer.parseInt(s));
            }
            else if(s.charAt(0) == '+') {
                st.push(st.pop() + st.pop());
            }
            else if(s.charAt(0) == '-') {
                int secondNumber = st.pop();
                int firstNumber = st.pop();
                st.push(firstNumber - secondNumber);
            }
            else if(s.charAt(0) == '*') {
                st.push(st.pop() * st.pop());
            }
            else if(s.charAt(0) == '/') {
                int secondNumber = st.pop();
                int firstNumber = st.pop();
                st.push(firstNumber / secondNumber);
            }
        }
        return st.pop();
    }

    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
