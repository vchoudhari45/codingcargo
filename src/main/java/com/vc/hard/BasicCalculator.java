package com.vc.hard;

import java.util.*;

class BasicCalculator {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;

        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            q.offer(s.charAt(i));
        }
        q.offer('+');
        return calculate(q);
    }

    private int calculate(Queue<Character> q) {
        int num = 0;
        Stack<Integer> st = new Stack<>();
        int prevSign = '+';

        while(!q.isEmpty()) {
            char ch = q.poll();

            if(ch == ' ') continue;

            else if(Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            else if(ch == '(') {
                num = calculate(q);
            }
            else {
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

                num = 0;
                prevSign = ch;
                if(ch == ')') break;
            }
        }

        int sum = 0;
        while(!st.isEmpty()) sum += st.pop();
        return sum;
    }
}