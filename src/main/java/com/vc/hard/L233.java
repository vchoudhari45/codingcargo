package com.vc.hard;

class L233 {
    public int countDigitOne(int n) {
        /**
         First look at ones place
         if number is 113, at ones place digit 1 appears 11 times in
         1, 11, 21, 31, 41, 51, 61, 71, 81, 91, 101

         so count += quotient * pow

         Now digit 1 Also appears at ones place 1 times in
         111
         Which can be calculated from remainder

         so count += Math.min(pow, remainder - pow + 1)
         */
        int count = 0;
        for(long pow = 1; pow <= n; pow *= 10) {
            long divisor = pow * 10;

            long quotient = n / divisor;
            long remainder = n % divisor;

            count += quotient * pow;
            if(remainder >= pow) {
                count += Math.min(pow, remainder - pow + 1);
            }
        }
        return count;
    }
}