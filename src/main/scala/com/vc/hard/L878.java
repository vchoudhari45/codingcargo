package com.vc.hard;

class L878 {
    public int nthMagicalNumber(int N, int A, int B) {
        /**
         let X be the Magical number
         X / A = Count of numbers divisible by A
         X / B = Count of numbers divisible by B
         X / LCM(A, B) = Count of numbers divisible by Both

         X / A + X / B - X / LCM(A, B) = N (Inclusion & Exclusion Principal F(A) + F(B) - F(A UNION B) )
         Now we know A & B and LCM, we need to find the N using binary search

         and LCM(A, B) = A* B * GCD(A, B)
         */
        long lcm = A * B / gcd(A, B);
        long lo = 0;
        long hi = Long.MAX_VALUE;
        int MOD = (int)1e9 + 7;
        while(lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long res = mid / A + mid / B  - mid / lcm;
            if(res < N) lo = mid + 1;
            else hi = mid;
        }
        return (int)(lo % MOD);
    }

    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}