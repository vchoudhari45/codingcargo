package com.vc.medium;

import java.util.*;

class L556 {
    public int nextGreaterElement(int n) {
        char s[] = Integer.toString(n).toCharArray();
        int len = s.length;
        int from = -1;
        for(int i = len - 2; i >= 0; i--) {
            int current = s[i + 1];
            int prev = s[i];
            if(current > prev) {
                from = i;
                break;
            }
        }

        if(from == -1) return -1;

        int nge = from + 1;
        int element = s[from];
        for(int i = from + 1; i < len; i++) {
            if(element < s[i] && s[i] < s[nge]) {
                nge = i;
            }
        }

        char temp = s[from];
        s[from] = s[nge];
        s[nge] = temp;

        Arrays.sort(s, from + 1, len);
        long res = Long.parseLong(new String(s));
        if(res > Integer.MAX_VALUE) return -1;
        else return (int) res;
    }
}