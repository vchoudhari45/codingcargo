package com.vc.medium;

import java.util.*;

class L424 {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxCount = 0;
        for(int end = 0; end < s.length(); end++) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            maxCount = Math.max(maxCount, map.get(s.charAt(end)));
            while(end - start + 1 - maxCount > k) { //i.e No of non matching elements in window > k
                map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) - 1);
                start++;
            }
            maxLength = Math.max(end - start + 1, maxLength);
        }
        return maxLength;
    }
}
