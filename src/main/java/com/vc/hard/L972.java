package com.vc.hard;

class L972 {
    public boolean isRationalEqual(String S, String T) {
        return solve(S) == solve(T);
    }

    private double solve(String s) {
        int index = s.indexOf("(");
        if(index != -1) {
            String tBase = s.substring(0, index);
            String tDecimal = s.substring(index + 1, s.length() - 1);
            s = tBase;
            for(int i = 0; i < 20; i++) s += tDecimal;
        }
        return Double.parseDouble(s);
    }
}
