package com.vc.medium;

class L161 {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null ^ t == null) return false;
        if(s == null && t == null) return false;

        int n = s.length();
        int m = t.length();
        for(int i = 0; i < Math.min(n, m); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(n > m) return s.substring(i + 1).equals(t.substring(i));
                else if(n < m) return t.substring(i + 1).equals(s.substring(i));
                else return s.substring(i + 1).equals(t.substring(i + 1));
            }
        }
        return Math.abs(n - m) == 1;
    }
}
