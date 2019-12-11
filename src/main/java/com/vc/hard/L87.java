package com.vc.hard;

import java.util.*;

class L87 {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(!sort(s1).equals(sort(s2))) return false;

        //s1 => great   s2 => rgeat
        for(int i = 1; i < s1.length(); i++) {
            String s1Left = s1.substring(0, i);     //g
            String s1Right = s1.substring(i);       //reat

            String s2Left = s2.substring(0, i);     //r
            String s2Right = s2.substring(i);       //geat

            String s2ReverseRight = s2.substring(s2.length() - i);         //t
            String s2ReverseLeft  = s2.substring(0, s2.length() - i);      //rgea

            //System.out.println(s1Left+" "+s1Right+" "+s2Left+" "+s2Right+" "+s2ReverseRight+" "+s2ReverseLeft);

            if(isScramble(s1Left, s2Left) && isScramble(s1Right, s2Right)) return true;
            if(isScramble(s1Left, s2ReverseRight) && isScramble(s1Right, s2ReverseLeft)) return true;
        }
        return false;
    }

    private String sort(String s) {
        char[] cArr = s.toCharArray();
        Arrays.sort(cArr);
        return new String(cArr);
    }
}
