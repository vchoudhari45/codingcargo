package com.vc.hard;

import java.util.*;

class L224 {
    public int calculate(String s) {
        int sum = 0;
        int n = s.length();
        int sign = 1;
        int num = 0;
        int i = 0;
        Stack<Integer> st = new Stack<Integer>();
        while(i < n) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            else if(ch == '+') {
                sum += sign * num;
                num = 0;
                sign = 1;
            }
            else if(ch == '-') {
                sum += sign * num;
                num = 0;
                sign = -1;
            }
            else if(ch == '(') {
                st.push(sum);
                st.push(sign);
                sign = 1;
                sum = 0;
            }
            else if(ch == ')') {
                int prevSign = st.pop();
                int prevNum = st.pop();
                sum += sign * num;
                sum *= prevSign;
                sum += prevNum;
                num = 0;
            }
            i++;
        }
        if(num != 0) sum += sign * num;
        return sum;
    }
}
