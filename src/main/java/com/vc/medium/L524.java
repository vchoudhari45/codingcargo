package com.vc.medium;

import java.util.*;

class L524 {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>(){
            public int compare(String s1, String s2) {
                int cmp = Integer.compare(s2.length(), s1.length());
                if(cmp == 0) return s1.compareTo(s2);
                return cmp;
            }
        });
        for(String str: d) {
            int i = 0;
            int j = 0;
            while(i < str.length() && j < s.length()) {
                if(str.charAt(i) == s.charAt(j)) {
                    i++;
                    j++;
                }
                else j++;
            }
            if(i == str.length()) return str;
        }
        return "";
    }
}
