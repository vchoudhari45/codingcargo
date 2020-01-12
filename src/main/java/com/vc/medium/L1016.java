package com.vc.medium;

class L1016 {
    public boolean queryString(String S, int N) {
        int n = 0;
        for(int i = 1; i <= N; i++) {
            String s = Integer.toBinaryString(i);
            if(!S.contains(s)) return false;
        }
        return true;
    }
}
