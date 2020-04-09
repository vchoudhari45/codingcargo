package com.vc.hard;

import java.util.*;

class L76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int target = 0;
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            target++;
        }

        /**
                 T = ABC
                 S = ABACKM

                 target = 1
                 len = I

                 A -> 0
                 B -> 1
                 C -> 0
         */
        int resIndex = 0;
        int start = 0, end = 0, len = Integer.MAX_VALUE;
        while(end < s.length()) {
            char ch = s.charAt(end);
            if(map.containsKey(ch)) {
                if(map.get(ch) > 0) {
                    map.put(ch, map.get(ch) - 1);
                    target--;
                    while(target == 0) {
                        if(end - start + 1 < len) {
                            len = end - start + 1;
                            resIndex = start;
                            //System.out.println("Value: "+s.substring(start, end + 1));
                        }
                        char chs = s.charAt(start);
                        if(map.containsKey(chs)) {
                            if(map.get(chs) >= 0) target++;
                            map.put(chs, map.get(chs) + 1);
                        }
                        start++;
                    }
                }
                else map.put(ch, map.get(ch) - 1);
            }
            else {
                //Do Nothing;
            }
            end++;
        }
        //System.out.println("resIndex: "+resIndex);
        return len == Integer.MAX_VALUE ? "" : s.substring(resIndex, resIndex + len);
    }
}