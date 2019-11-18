package com.vc.hard;

import java.util.*;

class L772 {
    public int calculate(String s) {
        Queue<Character> q = new LinkedList<Character>();
        for(int i = 0; i < s.length(); i++) {
            q.offer(s.charAt(i));
        }
        q.offer('+');
        return solve(q);
    }

    public int solve(Queue<Character> q) {
        int sum = 0;
        char prevSign = '+';

        Stack<Integer> st = new Stack<Integer>();
        int num = 0;

        while(!q.isEmpty()) {
            char ch = q.poll();
            if(ch == ' ') continue;

            if(ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            }
            else if(ch == '(') {
                num = solve(q);
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
                if(ch == ')') break;
            }
        }
        while(!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;
    }
}