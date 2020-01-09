package com.vc.hard;

class L829 {
    public int consecutiveNumbersSum(int N) {
        /**
             x + (x + 1) + (x + 2) .... = N
             kx + (1 + 2 + ..... + k) = N
             kx + k(k + 1) / 2 = N
             kx = N - k(k + 1)/2
             x = (N - k(k + 1)/2) / k

             if rhs of the equation is an integer number that means
             N can be represented as sum of number starting from x

             find the range for k
             since (N - k(k + 1)/2) / k is +ve integer
             (N - k(k + 1)/2) / k > 0
             N  > k(k + 1)/2
             2N  > k(k + 1)
             2N  > k^2
             sqrt(2N) > k
        */
        int res = 0;
        for(int k = 1; k < Math.sqrt(2 * N); k++){
            if((N - (k * (k + 1) / 2)) % k == 0) res++;
        }
        return res;
    }
}
