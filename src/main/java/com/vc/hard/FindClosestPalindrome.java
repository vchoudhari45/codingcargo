package com.vc.hard;

import java.util.HashSet;

class FindClosestPalindrome {
    public String nearestPalindromic(String n) {
        int len = n.length();

        int middleIndex = len % 2 == 0 ? len / 2 - 1: len / 2;
        long prefix = Long.parseLong(n.substring(0, middleIndex + 1));

        HashSet<Long> candidates = new HashSet<>();
        candidates.add(helper(prefix, len % 2 == 1));
        candidates.add(helper(prefix + 1,  len % 2 == 1));
        candidates.add(helper(prefix - 1,  len % 2 == 1));
        candidates.add((long)Math.pow(10, len - 1) - 1);
        candidates.add((long)Math.pow(10, len) + 1);

        long diff = Long.MAX_VALUE;
        long res = Long.MAX_VALUE;
        long number = Long.parseLong(n);
        for(long candidate: candidates) {
            if(candidate == number) continue;
            else {
                if(Math.abs(number - candidate) < diff) {
                    diff = Math.abs(number - candidate);
                    res = candidate;
                }
                else if(Math.abs(number - candidate) == diff) {
                    res = Math.min(candidate, res);
                }
            }
        }
        return String.valueOf(res);
    }

    private long helper(long left, boolean isLengthOdd) {
        long res = left;
        if(isLengthOdd) left = left / 10;
        while(left > 0) {
            res *= 10;
            res += left % 10;
            left /= 10;
        }
        return res;
    }
}