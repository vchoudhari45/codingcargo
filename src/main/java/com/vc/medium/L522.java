package com.vc.medium;

import java.util.*;

class L522 {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String s1, String s2) {
                return Integer.compare(s2.length(), s1.length());
            }
        });

        Set<String> duplicates = duplicates(strs);
        for(int i = 0; i < strs.length; i++) {
            if(!duplicates.contains(strs[i])) {
                boolean flag = true;
                for(int j = 0; j < i; j++) {
                    if(isSubsequence(strs[j], strs[i])) {
                        flag = false;
                        break;
                    }
                }
                if(flag) return strs[i].length();
            }
        }
        return -1;
    }


    private boolean isSubsequence(String a, String b) {
        int ib = 0;
        int i = 0;
        while(i < a.length() && ib < b.length()) {
            if(a.charAt(i) == b.charAt(ib)) ib++;
            i++;
        }
        //System.out.println(a+" "+b+" -> "+(ib == b.length()));
        return ib == b.length();
    }

    private Set<String> duplicates(String[] strs) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> duplicates = new HashSet<>();
        for(String str: strs) {
            if(!set.add(str)) duplicates.add(str);
        }
        return duplicates;
    }
}
