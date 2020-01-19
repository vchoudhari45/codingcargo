package com.vc.medium;

class L365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z) return false;
        else if(x == z || y == z || x + y == z) return true;
        else return z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}
