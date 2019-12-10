package com.vc.hard;

import java.util.*;

class L902 {
    public int atMostNGivenDigitSet(String[] D, int N) {
        N++;
        List<Integer> digits = getDigits(N);

        int digitCount = digits.size();
        int arrayCount = D.length;
        int res = 0;
        for(int i = 1; i < digitCount; i++) {
            res += permute(arrayCount, i);
        }

        System.out.println(res);

        for(int i = digitCount - 1; i >= 0; i--) {
            int digit = digits.get(i);
            int lessThanDigit = getLessThanDigitCount(digit, D);
            int add = lessThanDigit * permute(arrayCount, i);
            res += add;
            boolean equalToDigit = containsDigit(digit, D);
            if(!equalToDigit) break;
        }

        return res;
    }

    private boolean containsDigit(int digit, String[] digits) {
        for(String s: digits) {
            int d = s.charAt(0) - '0';
            if(d == digit) return true;
        }
        return false;
    }

    private int getLessThanDigitCount(int digit, String[] digits) {
        int count = 0;
        for(String s: digits) {
            int d = s.charAt(0) - '0';
            if(d < digit) count++;
        }
        return count;
    }

    private List<Integer> getDigits(int N) {
        List<Integer> digits = new ArrayList<Integer>();
        while(N != 0) {
            digits.add(N % 10);
            N = N / 10;
        }
        return digits;
    }

    /**
         Given: {"1","3","5","7"}
         Numbers will be
         11,
         13,
         15,
         17,
         33,
         31,
         35,
         37,
         55,
         51,
         53,
         57,
         77,
         71,
         73,
         75
     */
    private int permute(int n, int r) {
        int numerator = n;
        int denominator = (n - r);

        int res = 1;
        while(numerator > denominator) {
            res *= n;
            numerator--;
        }
        return res;
    }
}