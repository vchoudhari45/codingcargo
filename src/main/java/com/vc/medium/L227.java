package com.vc.medium;

import java.util.*;

class L227 {
    public int calculate(String s) {
        s += "+";
        int sum = 0;
        char prevSign = '+';

        Stack<Integer> st = new Stack<Integer>();
        int num = 0;

        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i++);
            if(ch == ' ') continue;

            if(ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            }
            else {
                if(prevSign == '+') {
                    st.push(num);
                }
                else if(prevSign == '-') {
                    st.push(num * -1);
                }
                else if(prevSign == '*') {
                    st.push(st.pop() * num);
                }
                else if(prevSign == '/') {
                    st.push(st.pop() / num);
                }
                prevSign = ch;
                num = 0;
            }
        }
        while(!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;
    }
}