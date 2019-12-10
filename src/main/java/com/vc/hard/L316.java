package com.vc.hard;

import java.util.*;

class L316 {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        HashSet<Character> set = new HashSet<Character>();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!set.contains(ch)) {
                while(!st.isEmpty() && st.peek() > ch && map.get(st.peek()) > i) {
                    set.remove(st.pop());
                }
                set.add(ch);
                st.push(ch);
            }
        }

        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()) {
            str.insert(0, st.pop());
        }
        return str.toString();
    }
}
