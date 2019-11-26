package com.vc.hard;

import java.util.*;

class L479 {
    public int largestPalindrome(int n) {
        long lo = n > 1 ? Long.parseLong(repeat("9", n - 1)) : 0;
        long hi = Long.parseLong(repeat("9", n));
        long prevPalindrome = hi * hi + 1;
        long maxProduct = prevPalindrome;
        //System.out.println(prevPalindrome+" "+maxProduct);
        while(prevPalindrome > lo) {
            prevPalindrome = getPrevPalindrome(prevPalindrome);
            //System.out.println(prevPalindrome);
            if(prevPalindrome < maxProduct) {
                for(long factor1 = hi; factor1 > lo; factor1--) {
                    boolean isDivisible = prevPalindrome % factor1 == 0;
                    long factor2 = prevPalindrome / factor1;
                    if(factor2 > hi) break;
                    if(isDivisible && factor2 > lo && factor2 <= hi && factor1 != factor2) {
                        //System.out.println("Factor1: "+factor1+" Factor2: "+factor2);
                        return (int)(prevPalindrome % 1337L);
                    }
                }
            }
            prevPalindrome--;
        }
        return 1;
    }

    private long getPrevPalindrome(Long maxProduct) {
        if(maxProduct <= 10) return --maxProduct;
        else if(maxProduct == 11) return 9;

        String str = Long.toString(maxProduct);
        int len = (str.length() + 1) / 2;

        StringBuilder firstBuilder = new StringBuilder(str.substring(0, len));
        String first = firstBuilder.toString();
        String firstReverse = firstBuilder.reverse().toString();
        long cand1 = Long.parseLong(first + firstReverse);

        long prev = Long.parseLong(first) - 1;
        StringBuilder secondBuilder = new StringBuilder(Long.toString(prev));
        String second = secondBuilder.toString();
        String secondReverse = secondBuilder.reverse().toString();
        long cand2 = Long.parseLong(second + secondReverse);

        return Math.min(cand1, cand2);
    }

    private String repeat(String a, int n) {
        String str = "";
        for(int i = 0; i < n; i++) str += a;
        return str;
    }
}