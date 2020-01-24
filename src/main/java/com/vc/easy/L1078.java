package com.vc.easy;

import java.util.*;

class L1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] str = text.split(" ");
        List<String> res = new ArrayList<>();
        for(int i = 0; i < str.length - 2; i++) {
            if(str[i].equals(first) && str[i + 1].equals(second)) res.add(str[i + 2]);
        }
        String[] r = new String[res.size()];
        for(int i = 0; i < res.size(); i++) r[i] = res.get(i);
        return r;
    }
}
