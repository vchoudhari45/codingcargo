package com.vc.hard;

import java.util.*;

class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        //Last occurrence of character
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!set.contains(ch)) {
                while(!st.isEmpty() && st.peek() > ch && map.get(st.peek()) > i) {
                    set.remove(st.pop());
                }
                st.push(ch);
            }
            set.add(ch);
        }

        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()) {
            str.insert(0, st.pop());
        }
        return str.toString();
    }
}