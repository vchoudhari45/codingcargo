package com.vc.hard;

import java.util.*;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s == null || t == null) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int start = 0;
        int end = 0;
        int required = t.length();
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        while(end < s.length()) {
            char ch = s.charAt(end);
            if(map.containsKey(ch)) {
                if(map.get(ch) > 0) required--;
                map.put(ch, map.get(ch) - 1);
                while(required == 0) {
                    if(minLength > end - start) {
                        minLength = end - start + 1;
                        minStart = start;
                    }
                    char c = s.charAt(start);
                    if(map.containsKey(c)) {
                        map.put(c, map.getOrDefault(c, 0) + 1);
                        if(map.get(c) > 0) required++;
                    }
                    start++;
                }
            }
            end++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}