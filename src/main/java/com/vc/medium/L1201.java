package com.vc.medium;

class L1201 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long lo = 1;
        long hi = Integer.MAX_VALUE;
        while(lo < hi) {
            long mid = lo + (hi - lo) / 2;
            /**
                 mid / a -> total numbers divisible by a
                 mid / b -> total numbers divisible by b
                 mid / c -> total numbers divisible by c

                 mid / lcm(a, b) -> total numbers divisible by both a & b
                 mid / lcm(a, c) -> total numbers divisible by both a & c
                 mid / lcm(b, c) -> total numbers divisible by both b & c

                 mid / lcm(lcm(a, b), c) -> total numbers divisible by a, b & c
             */
            long total = mid / a + mid / b + mid / c
                    - mid / lcm(a, b) - mid / lcm(a, c) - mid / lcm(b, c)
                    + mid / lcm(lcm(a, b), c);

            if(total < n) lo = mid + 1;
            else hi = mid;
        }
        return (int)lo;
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
    private long gcd(long a, long b) {
        long oldA = a;
        while(b != 0) {
            oldA = a;
            a = b;
            b = oldA % b;
        }
        return a;
    }
}
