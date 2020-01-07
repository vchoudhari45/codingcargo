package com.vc.hard;

class L793 {
    //https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/discuss/117821/Four-binary-search-solutions-based-on-different-ideas
    public int preimageSizeFZF(int k) {
        long countNext = numbersWithKTrailingZeros(k + 1);
        long countPrev = numbersWithKTrailingZeros(k);
        //System.out.println(countNext+" "+countPrev);
        return (int)(countNext - countPrev);
    }

    private long numbersWithKTrailingZeros(int k) {
        long lo = 0;
        long hi = 5 * (k + 1);
        while(lo < hi) {
            long mid = lo + (hi - lo) / 2;
            int zerosForMid = numbersOfZeros(mid);
            if(zerosForMid < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private int numbersOfZeros(long n) {
        int res = 0;
        while(n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}