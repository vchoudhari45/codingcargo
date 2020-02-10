package com.vc.medium;

import java.util.HashSet;

class L3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0) return 0;

        HashSet set = new HashSet<>();
        int end = 0, start = 0, res = 0;
        while(end < s.length()) {
            char ch = s.charAt(end);
            while(start < s.length() && set.contains(ch)) {
                char toBeRemoved = s.charAt(start);
                set.remove(toBeRemoved);
                start++;
                if(toBeRemoved == ch) break;
            }
            if(!set.contains(ch)) res = Math.max(res, end - start + 1);
            set.add(ch);
            end++;
        }
        return res;
    }
}
