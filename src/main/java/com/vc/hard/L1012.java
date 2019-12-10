package com.vc.hard;

import java.util.*;

class L1012 {
    public int numDupDigitsAtMostN(int N) {
        List<Integer> digits = getDigitCount(N);

        //Find numbers without repeated digits, given numbers of digits
        int numbersWithoutDupCount = numbersWithoutDups(digits.size());

        //But above function won't calculate all the numbers without repeated digits
        //Because function stops at digitCount - 1
        HashSet<Integer> seen = new HashSet<Integer>();
        boolean uniqNum = true;
        for(int i = digits.size() - 1; i >= 0; i--) {
            for(int j = (i == digits.size() - 1) ? 1: 0; j < digits.get(i); j++) {
                if(!seen.contains(j)) {
                    numbersWithoutDupCount += permute(digits.size(), digits.size() - i);
                }
            }
            if(seen.contains(digits.get(i))) {
                uniqNum = false;
                break;
            }
            seen.add(digits.get(i));
        }
        if(uniqNum) numbersWithoutDupCount++;
        return N - numbersWithoutDupCount;
    }

    private int numbersWithoutDups(int digitCount) {
        int res = 0;
        for(int i = 1; i < digitCount; i++) {
            res += 9 * permute(i, 1);
        }
        return res;
    }

    private List<Integer> getDigitCount(int N) {
        List<Integer> digits = new ArrayList<Integer>();
        while(N != 0) {
            int digit = N % 10;
            digits.add(digit);
            N = N / 10;
        }
        return digits;
    }

    private int permute(int selectDigits, int selectedDigits) {
        int n = 10;
        int res = 1;
        int numerator = 10 - selectedDigits;
        int denominator = 10 - selectDigits;

        /**
             Permutation formula: p(n, r) = n! / (n - r)!
             Which means arrange 'r' elements at a time from given 'n' elements
             n elements are 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 = Total 10 elements

             For this function
             selectedDigits: Number of digits that we have already selected
             selectDigit:    Number of digits that we still have to select

             let's say selectedDigits = 2, so n in Permutation formula becomes (n - 2)!
             and that is why numerator is 10 - selectedDigits

             let's say selectDigit = 3, so (n - r) in Permuation formula becomes (n - 3)!

             Permuation = (n - 2)! / (n - 3)!
             = (n - 2) * (n - 3)! / (n - 3)!
             = (n - 2)
        */
        while(numerator > denominator) {
            res *= numerator--;
        }
        return res;
    }
}