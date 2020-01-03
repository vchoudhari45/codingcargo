package com.vc.hard;

class L727 {
    public String minWindow(String S, String T) {
        int n = S.length();
        int m = T.length();
        if(n == 0 || m == 0) return "";
        int startIndex = -1;
        String res = "";
        int minLength = Integer.MAX_VALUE;
        while(true) {
            startIndex = S.indexOf(T.charAt(0), startIndex + 1);
            //System.out.println("startIndex: "+startIndex);
            if(startIndex == -1) return res;
            int i = startIndex + 1;
            int j = 1;
            while(j < T.length() && i < S.length()) {
                if(S.charAt(i) == T.charAt(j)) j++;
                i++;
            }
            if(j == T.length()) {
                int length = i - startIndex + 1;
                if(minLength > length){
                    minLength = length;
                    res = S.substring(startIndex, i);
                }
                //System.out.println("startIndex: "+startIndex+" res: "+res);
            }
            else return res;
        }
    }
}