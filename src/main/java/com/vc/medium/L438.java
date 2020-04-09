package com.vc.medium;

import java.util.*;

class L438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();

        HashMap<Character, Integer> sMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }

        int target = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i < p.length(); i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            target++;
        }

        //System.out.println(map);
        //System.out.println(sMap);
        //cbaebabacd
        //0123456789
        int start = 0, end = 0;
        while(end < s.length()) {
            char chs = s.charAt(end);
            //System.out.println(map+" target: "+target+" start: "+start+" end: "+end);
            if(map.containsKey(chs)) {
                if(map.get(chs) > 0) {
                    map.put(chs, map.get(chs) - 1);
                    target--;
                    if(target == 0) {
                        res.add(start);
                        char ch = s.charAt(start++);
                        map.put(ch, map.get(ch) + 1);
                        target++;
                    }
                }
                else {
                    while(start < end && s.charAt(start) != chs) {
                        char ch = s.charAt(start++);
                        map.put(ch, map.get(ch) + 1);
                        target++;
                    }
                    start++;
                }
            }
            else {
                while(start < end) {
                    char ch = s.charAt(start++);
                    map.put(ch, map.get(ch) + 1);
                    target++;
                }
                start = end + 1;
            }
            end++;
        }
        return res;
    }
}
