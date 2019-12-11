package com.vc.hard;

import java.util.*;

class L76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        String res = "";
        int len = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int size = t.length();
        while(end < s.length()) {
            char ch = s.charAt(end);
            // System.out.println("size: "+size
            //                    + " ch: "+ch+" start: "+start+" end: "+end+" map: "+map);
            if(map.containsKey(ch)) {
                if(map.get(ch) > 0) size--;
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                // System.out.println("------> size: "+size
                //                + " ch: "+ch+" start: "+start+" end: "+end+" map: "+map);
                while(size == 0) {
                    if(len > end - start + 1) {
                        len = end - start + 1;
                        res = s.substring(start, end + 1);
                    }
                    char chs = s.charAt(start);
                    if(map.containsKey(chs)) {
                        if(map.get(chs) == 0) size++;
                        map.put(chs, map.getOrDefault(chs, 0) + 1);
                        // System.out.println("---> size: "+size
                        //        + " ch: "+chs+" start: "+start+" end: "+end+" map: "+map);
                    }
                    start++;
                }
            }
            end++;
        }
        return res;
    }
}
