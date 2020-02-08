package com.vc.hard;

import java.util.Arrays;

class L899 {
    public String orderlyQueue(String S, int K) {
        if(K > 1) {
            char[] arr = S.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
        else {
            String res = S;
            String sNew = S;
            for(int i = 0; i < S.length(); i++) {
                //System.out.println(sNew);
                sNew = S.substring(i) + S.substring(0, i);
                if(sNew.compareTo(res) < 0) res = sNew;
            }
            return res;
        }
    }
}
