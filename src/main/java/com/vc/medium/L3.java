package com.vc.medium;

import java.util.HashSet;

class L3 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        int start = 0, end = 0, n = s.length(), max = 0;
        HashSet<Character> duplicate = new HashSet<>();
        while(end < n) {
            char ch = s.charAt(end++);
            if(duplicate.contains(ch)) {
                while(s.charAt(start) != ch) duplicate.remove(s.charAt(start++));
                start++;
            }
            duplicate.add(ch);
            max = Math.max(max, end - start);
        }
        return max;
    }
}