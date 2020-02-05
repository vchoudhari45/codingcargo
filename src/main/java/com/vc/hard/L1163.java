package com.vc.hard;

class L1163 {
    public String lastSubstring(String s) {
        int i = 0, j = 1, offset = 0;
        int len = s.length();
        while(i + offset < len && j + offset < len) {
            char c = s.charAt(i + offset);
            char d = s.charAt(j + offset);
            if(c == d) offset++;
            else {
                if(c < d) i += offset + 1;
                else j += offset + 1;
                if(i == j) i++;
                offset = 0;
            }
        }
        return s.substring(Math.min(i, j));
    }
}