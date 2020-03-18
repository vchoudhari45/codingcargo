package com.vc.easy;

class L7 {
    public int reverse(int x) {
        long res = 0;
        boolean isNeg = false;
        if(x < 0) {
            x = -x;
            isNeg = true;
        }
        while(x > 0) {
            int digit = x % 10;
            x = x / 10;
            res = res * 10 + digit;
        }
        res = isNeg ? -res : res;
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        else return (int)res;
    }
}
