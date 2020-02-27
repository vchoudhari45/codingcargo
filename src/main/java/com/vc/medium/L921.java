package com.vc.medium;

import java.util.*;

class L921 {
    public int minAddToMakeValid(String S) {
        Stack<Character> st = new Stack<>();
        int res = 0;
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if(ch == '(') st.push(ch);
            else {
                if(!st.isEmpty()) st.pop();
                else res++;
            }
        }
        return res + st.size();
    }
}
