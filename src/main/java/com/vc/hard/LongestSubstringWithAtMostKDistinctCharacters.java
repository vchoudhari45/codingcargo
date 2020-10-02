package com.vc.hard;

import java.util.*;

class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int right = 0, left = 0, maxLength = 0;
        while(right < s.length()) {
            char ch = s.charAt(right);
            map.put(ch, right++);
            if(map.size() == k + 1) {
                int index = Collections.min(map.values());
                map.remove(s.charAt(index));
                left = index + 1;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
