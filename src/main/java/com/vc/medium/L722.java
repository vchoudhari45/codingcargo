package com.vc.medium;

import java.util.*;

class L722 {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        boolean inBlock = false;
        StringBuilder sb = new StringBuilder();
        for(String s : source) {
            for(int i = 0; i < s.length(); i++) {
                if(inBlock) {
                    if(s.charAt(i) == '*' && i + 1 < s.length() && s.charAt(i + 1) == '/') {
                        inBlock = false;
                        i++;
                    }
                }
                else {
                    if(s.charAt(i) == '/' && i + 1 < s.length() && s.charAt(i + 1) == '*') {
                        inBlock = true;
                        i++;
                    }
                    else if(s.charAt(i) == '/' && i + 1 < s.length() && s.charAt(i + 1) == '/') {
                        break;
                    }
                    else sb.append(s.charAt(i));
                }
            }
            if(!inBlock && sb.length() > 0) {
                res.add(sb.toString());
                sb.setLength(0);
            }
        }
        return res;
    }
}
