package com.vc.medium;

import java.util.*;

class L227 {
    public int calculate(String s) {
        int sum = 0;
        int i = 0;

        Set<Character> set = new HashSet<Character>();
        set.add('+');
        set.add('-');
        set.add('*');
        set.add('/');

        Stack<Integer> st = new Stack<Integer>();
        char prevSign = '+';
        int n = s.length();

        int num = 0;
        while(i < n) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if(set.contains(ch) || i == n - 1) {
                if(prevSign == '+') {
                    st.push(num);
                }
                else if(prevSign == '-') {
                    st.push(-1 * num);
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
            i++;
        }
        while(!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;
    }
}