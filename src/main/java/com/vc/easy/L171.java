package com.vc.easy;

class L171 {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) return 0;

        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            res = res * 26 + (ch - 'A' + 1);
        }
        return res;
    }
}
