package com.vc.hard;

class L727 {
    public String minWindow(String S, String T) {
        int sn = S.length();
        int tn = T.length();

        int res = -1;
        int min = Integer.MAX_VALUE;
        int i = 0;
        while(i < sn) {
            int start = S.indexOf(T.charAt(0), i);
            if(start == -1) break;

            int sIndex = start;
            int tIndex = 0;
            while(sIndex < sn && tIndex < tn) {
                if(S.charAt(sIndex) == T.charAt(tIndex)) {
                    tIndex++;
                    sIndex++;
                }
                else sIndex++;
            }

            if(tIndex == tn) {
                int end = sIndex - 1;
                int len = end - start + 1;
                if(min > len) {
                    min = len;
                    res = start;
                }
            }
            i++;
        }
        if(res == -1) return "";
        else return S.substring(res, res + min);
    }
}
