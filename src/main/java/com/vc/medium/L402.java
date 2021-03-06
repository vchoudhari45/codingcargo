package com.vc.medium;

import java.util.*;

class L402 {
    public String removeKdigits(String str, int k) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            while(!st.isEmpty() && st.peek() > str.charAt(i) && k > 0) {
                st.pop();
                k--;
            }
            st.push(str.charAt(i));
        }

        while(k > 0) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.insert(0, st.pop());
        }

        int index = 0;
        while(index < sb.length() && sb.charAt(index) == '0') index++;
        String res = sb.substring(index);

        return res.length() == 0 ? "0" : res;
    }
}