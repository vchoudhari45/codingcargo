package com.vc.medium;

import java.util.*;

class L916 {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] b = new int[26];
        for(String str: B) {
            int[] count = new int[26];
            for(char ch: str.toCharArray()) {
                count[ch - 'a']++;
            }
            for(int i = 0; i < b.length; i++) {
                b[i] = Math.max(b[i], count[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for(String str: A) {
            int[] a = new int[26];
            for(char ch: str.toCharArray()) {
                a[ch - 'a']++;
            }
            if(isValid(a, b)) res.add(str);
        }
        return res;
    }

    private boolean isValid(int[] a, int[] b) {
        for(int i = 0; i < a.length; i++) {
            if(a[i] < b[i]) return false;
        }
        return true;
    }
}
