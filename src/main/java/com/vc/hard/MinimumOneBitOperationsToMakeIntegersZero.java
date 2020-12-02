package com.vc.hard;

class MinimumOneBitOperationsToMakeIntegersZero {
    public int minimumOneBitOperations(int n) {
        int output = 0;

        while(n > 0) {
            output ^= n;
            n = n >> 1;
        }

        return output;
    }
}