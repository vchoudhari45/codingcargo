package com.vc.hard;

import java.util.*;

class L340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int end = 0;
        int start = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        while(end < n) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            //System.out.println("ch: "+ch+" Map: "+map+" size: "+map.size()+" start: "+start+" end: "+end);
            while(map.size() > k) {
                char chs = s.charAt(start++);
                map.put(chs, map.get(chs) - 1);
                if(map.get(chs) == 0) map.remove(chs);
                //System.out.println("---> chs: "+chs+" Map: "+map);
            }
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }
}
