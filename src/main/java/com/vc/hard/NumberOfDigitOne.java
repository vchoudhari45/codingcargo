package com.vc.hard;

class NumberOfDigitOne {
    public int countDigitOne(int n) {
        /**
             let's say number is 13

             Now at Unit place digit 1 appears 2 times in 1, 11

                 Unit place so pow = 1
                    quotient  = 13 / 10 = 1
                    remainder = 13 % 10 = 3

                 count += quotient * pow
                    count += 1 * 1
                    count = 1

                 count += Math.min(pow, remainder - pow + 1)
                    count += Math.min(1, 3 - 1 + 1) = 1
                    count  = 2

             Now at Tenth place digit 1 appear 4 times in 10, 11, 12, 13

                 Tenth place so pow = 10
                    quotient = 13 / 100 = 0
                    remainder = 13 % 100 = 13

                 count += quotient * pow
                    count += 0 * 10
                    count = 2

                 count += Math.min(pow, remainder - pow + 1)
                    count += Math.min(10, 13 - 10 + 1) = 4
                    count = 6
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