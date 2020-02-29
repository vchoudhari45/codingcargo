package com.vc.medium;

class L1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        /**
            [1,0,1,2,1,1,7,5]
            [0,1,0,1,0,1,0,1]
         */
        int n = customers.length;
        if(n == 0) return 0;

        int res = 0;
        for(int i = 0; i < customers.length; i++) {
            if(grumpy[i] == 0) res += customers[i];
        }

        int g = 0;
        for(int i = 0; i < X; i++) {
            if(grumpy[i] == 1) g += customers[i];
        }

        int max = res + g;
        for(int i = X; i < n; i++) {
            if(grumpy[i - X] == 1) g -= customers[i - X];
            if(grumpy[i] == 1) g += customers[i];
            max = Math.max(max, res + g);
        }
        return max;
    }
}
