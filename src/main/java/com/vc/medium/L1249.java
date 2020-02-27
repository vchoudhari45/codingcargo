package com.vc.medium;

import java.util.*;

class L1249 {
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if(ch == '(') st.push(i);
            else if(ch == ')') {
                if(!st.isEmpty()) st.pop();
                else arr[i] = '-';
            }
        }
        while(!st.isEmpty()) arr[st.pop()] = '-';
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != '-') str.append(arr[i]);
        }
        return str.toString();
    }
}
