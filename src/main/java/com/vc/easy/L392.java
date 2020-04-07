package com.vc.easy;

class L392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int n = s.length(), m = t.length();
        while(i < n && j < m) {
            while(j < m && s.charAt(i) != t.charAt(j)) j++;
            if(j >= m || t.charAt(j) != s.charAt(i)) return false;
            i++;
            j++;
        }
        return i == s.length();
    }
}
