package com.vc.medium;

import java.util.*;

class L816 {
    public List<String> ambiguousCoordinates(String S) {
        S = S.substring(1, S.length() - 1);
        List<String> list = new ArrayList<>();
        for(int i = 1; i < S.length(); i++) {
            List<String> left = allowed(S.substring(0, i));
            List<String> right = allowed(S.substring(i));
            for(String l: left) {
                for(String r: right) {
                    list.add("("+l+", "+r+")");
                }
            }
        }
        return list;
    }

    private List<String> allowed(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        if(s.charAt(0) == '0' && s.charAt(n - 1) == '0') {
            if(n == 1) res.add("0");
            return res;
        }
        else if(s.charAt(0) == '0') {
            res.add("0."+s.substring(1));
            return res;
        }
        else if(s.charAt(n - 1) == '0') {
            res.add(s);
            return res;
        }
        res.add(s);
        for(int i = 1; i < n; i++) {
            res.add(s.substring(0, i)+"."+s.substring(i));
        }
        return res;
    }
}
