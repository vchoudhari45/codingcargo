package com.vc.easy;

import java.util.*;

class L1047 {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(!st.isEmpty() && st.peek() == s.charAt(i)) {
                if(!st.isEmpty() && st.peek() == s.charAt(i)) st.pop();
            }
            else st.push(s.charAt(i));
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()) str.append(st.pop());
        return str.reverse().toString();
    }
}
