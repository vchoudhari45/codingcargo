package com.vc.hard;

class L1250 {
    public boolean isGoodArray(int[] arr) {
        /**
         The basic idea is that for integers a and b, if gcd(a,b) = d,
         then there exist integers x and y, s.t a * x + b * y = d;

         This can be generalized for (n >= 2) . e.g. if gcd(a,b,c) = d,
         then there exist integers x, y, and z, s.t, a* x + b*y + c * z = d.

         Now this problem is just asking if gcd(x1, ......, xn) = 1
         */
        if(arr.length == 1 && arr[0] == 1) return true;
        int gcd = arr[0];
        for(int i = 1; i < arr.length; i++) {
            gcd = gcd(gcd, arr[i]);
            if(gcd == 1) return true;
        }
        return false;
    }

    public int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}
