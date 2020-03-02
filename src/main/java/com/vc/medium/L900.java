package com.vc.medium;

class RLEIterator {

    int index = 0, remaining = 0;
    int[] A;
    public RLEIterator(int[] A) {
        this.A = A;
        remaining = A[0];
    }

    public int next(int n) {
        if(remaining >= n) {
            remaining -= n;
            return A[index + 1];
        }
        else {
            n -= remaining;
            remaining = 0;
            index += 2;
            if(index >= A.length) return -1;
            else {
                remaining = A[index];
                return next(n);
            }
        }
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
