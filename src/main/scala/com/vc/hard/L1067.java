package com.vc.hard;

class L1067 {
    //https://leetcode.com/problems/number-of-digit-one/
    public int digitsCount(int d, int low, int high) {
        return countDigit(d, high) - countDigit(d, low - 1);
    }

    private int countDigit(int digit, int n) {
        int count = 0;
        for(long pow = 1; pow <= n; pow *= 10) {
            long divisor = pow * 10;

            long quotient = n / divisor;
            long remainder = n % divisor;

            count += quotient * pow;
            if(digit == 0) {
                count -= pow;
            }

            if(remainder >= digit * pow) {
                count += Math.min(remainder - digit * pow + 1, pow);
            }
        }
        return count;
    }
}
