package com.vc.easy;

class L509 {
    public int fib(int N) {
        if(N <= 1) return N;
        int f1 = 0;
        int f2 = 1;
        int f3 = 0;
        for(int i = 0; i < N - 1; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
