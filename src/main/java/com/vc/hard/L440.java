package com.vc.hard;

class L440 {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1;
        while(k > 0) {
            int step = findSteps(n, curr, curr + 1);
            if(step <= k) {
                curr += 1;
                k -= step;
            }
            else {
                curr *= 10;
                k -= 1;
            }
        }
        return curr;
    }

    private int findSteps(int n, long n1, long n2) {
        int step = 0;
        while(n1 <= n) {
            step += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return step;
    }
}