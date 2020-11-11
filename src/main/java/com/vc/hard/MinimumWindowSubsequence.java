package com.vc.hard;

class MinimumWindowSubsequence {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0) return "";

        String ans = "";
        int ti = 0, si = 0, end = 0;
        while(si < s.length()) {
            if(s.charAt(si) == t.charAt(ti)) {
                ti++;
                if(ti == t.length()) {
                    ti--;
                    end = si + 1;
                    while(ti >= 0) {
                        if(t.charAt(ti) == s.charAt(si)) ti--;
                        si--;
                    }
                    ti++;
                    si++;
                    if(ans.equals("") || ans.length() > end - si) {
                        ans = s.substring(si, end);
                    }
                }
            }
            si++;
        }
        return ans;
    }
}