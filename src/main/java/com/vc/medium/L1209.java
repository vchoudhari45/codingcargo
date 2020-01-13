package com.vc.medium;

import java.util.*;

class L1209 {
    static class Node {
        char ch;
        int count;

        Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Node> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek().ch == ch) {
                Node e = st.pop();
                e.count++;
                st.push(e);
                if(e.count == k) st.pop();
            }
            else st.push(new Node(ch, 1));
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()) {
            Node e = st.pop();
            for(int i = 0; i < e.count; i++) str.append(e.ch);
        }
        return str.reverse().toString();
    }
}
