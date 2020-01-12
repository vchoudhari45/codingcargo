package com.vc.medium;

import java.util.*;

class L1087 {
    public String[] expand(String S) {
        int n = S.length();
        if(n == 0) return new String[]{""};

        List<String> res = new ArrayList<>();
        char ch = S.charAt(0);
        if(ch == '{') {
            int index = 0;
            while(S.charAt(index) != '}') {
                index++;
            }
            String[] l = S.substring(1, index).split(",");
            String[] r = expand(S.substring(index + 1));
            for(String sl: l) {
                for(String sr: r) {
                    res.add(sl + sr);
                }
            }
        }
        else {
            String[] r = expand(S.substring(1));
            for(String sr : r) {
                res.add(S.charAt(0) + sr);
            }
        }

        Collections.sort(res);
        return res.toArray(new String[0]);
    }
}
