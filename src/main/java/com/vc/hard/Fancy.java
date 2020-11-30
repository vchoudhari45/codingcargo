package com.vc.hard;

import java.util.*;

class Fancy {
    private long totalAddValue = 0;
    private long totalMultValue = 1;
    private List<Integer> numbers;

    long MOD = (int)1e9 + 7;

    public Fancy() {
        numbers = new ArrayList<>();
    }

    public void append(int val) {
        long removeAddValue = (val - totalAddValue + MOD) % MOD;
        long removeMultValue = inverse(totalMultValue) % MOD;
        long newValue = (removeAddValue * removeMultValue) % MOD;
        numbers.add((int)newValue);
    }

    public void addAll(int inc) {
        totalAddValue = (totalAddValue + inc) % MOD;
    }

    public void multAll(int m) {
        totalAddValue = (totalAddValue * m) % MOD;
        totalMultValue = (totalMultValue * m) % MOD;
    }

    public int getIndex(int index) {
        if(index < 0 || index >= numbers.size()) return -1;

        long ax = (numbers.get(index) * totalMultValue) % MOD;
        long b = (ax + totalAddValue) % MOD;
        return (int)b;
    }

    private long inverse(long x) {
        return power(x, MOD - 2);
    }

    private long power(long x, long y) {
        if(y == 0) return 1;

        long p = power(x, y / 2) % MOD;
        p = (p * p) % MOD;

        return y % 2 == 0 ? p : (p * x) % MOD;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */
