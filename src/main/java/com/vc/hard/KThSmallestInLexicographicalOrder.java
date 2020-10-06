package com.vc.hard;

class KThSmallestInLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        long current = 1;
        k = k - 1;
        while(k > 0) {
            int steps = calculateSteps(n, current, current + 1);
            if(k >= steps) {
                k -= steps;
                current = current + 1;
            }
            else {
                k--;
                current = current * 10;
            }
        }
        return (int)current;
    }

    private int calculateSteps(int n, long n1, long n2) {
        int steps = 0;
        while(n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }
}