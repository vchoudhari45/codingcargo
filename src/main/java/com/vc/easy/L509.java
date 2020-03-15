package com.vc.easy;

class L509 {
    public int fib(int N) {
        int f0 = 0;
        int f1 = 1;
        int f2 = 0;
        if(N == 1) return 1;
        for(int i = 0; i <= N - 2; i++) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }
}
