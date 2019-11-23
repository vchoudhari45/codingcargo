package com.vc.hard;

class L793 {
    //https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/discuss/117821/Four-binary-search-solutions-based-on-different-ideas
    public int preimageSizeFZF(int K) {
        long numbersWithKMinusOneTrailingZero = numbersWithKTrailingZero(K - 1);
        long numbersWithKTrailingZero = numbersWithKTrailingZero(K);
        return (int) (numbersWithKTrailingZero - numbersWithKMinusOneTrailingZero);
    }

    private long numbersWithKTrailingZero(int K) {
        long lo = 0;
        long hi =  5L * (K + 1);
        while(lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long zerosForMid = numberOfTraillingZerosFor(mid);
            if(zerosForMid > K) {
                hi = mid - 1;
            }
            else if(zerosForMid <= K) {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private long numberOfTraillingZerosFor(long x) {
        long res = 0;
        while(x > 0) {
            res += x / 5;
            x = x / 5;
        }
        return res;
    }
}
