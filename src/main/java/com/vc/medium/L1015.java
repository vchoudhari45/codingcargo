package com.vc.medium;

class L1015 {
    public int smallestRepunitDivByK(int K) {
        if(K % 2 == 0 || K % 5 == 0) return -1;

        int n = 1, count = 1;
        while(n % K != 0) {
            n = (n * 10 + 1) % K;
            //System.out.println(n);
            count++;
        }
        return count;
    }
}
