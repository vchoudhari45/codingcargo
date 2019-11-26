package com.vc.hard;

import java.util.*;

class L479 {
    public int largestPalindrome(int n) {
        if(n == 1) return 9;
        long high = (int)Math.pow(10, n) - 1;
        long lo = (int)Math.pow(10, n - 1);
        long product = high * high;
        long firstHalf = (int)(product / Math.pow(10, n));
        //System.out.println("high: "+high+" low: "+lo+" product: "+product+" firstHalf: "+firstHalf);
        while(firstHalf > lo) {
            List<Long> p = generatePalindrome(firstHalf--);
            for(Long palindrome: p) {
                //System.out.println("palindrome: "+palindrome+" firstHalf: "+firstHalf);
                if(palindrome > product) continue;
                for(long factor1 = high; factor1 >= lo; factor1--) {
                    long factor2 = palindrome / factor1;
                    if(factor2 > high) break;
                    if(palindrome % factor1 == 0 &&  factor2 >= lo && factor2 <= high && factor2 != factor1) {
                        //System.out.println("palindrome: "+palindrome+" factor1: "+factor1+" factor2: "+factor2);
                        return (int)(palindrome % 1337L);
                    }
                }
            }
        }
        return -1;
    }

    private List<Long> generatePalindrome(long firstHalf) {
        List<Long> res = new ArrayList<Long>();
        StringBuilder str = new StringBuilder(Long.toString(firstHalf));
        String firstPart = str.toString();
        String secondPart = str.reverse().toString();
        String r = firstPart+secondPart;
        res.add(Long.parseLong(r));
        for(char c = '0'; c <='9'; c++) {
            res.add(Long.parseLong(firstPart+c+secondPart));
        }
        return res;
    }
}