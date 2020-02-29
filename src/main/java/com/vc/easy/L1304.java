package com.vc.easy;

class L1304 {
    public int[] sumZero(int n) {
        int[] res = new int[n];

        int index = 0;
        if(n % 2 != 0) index++;
        int num = 1;
        for(int i = index; i < n;) {
            res[i++] = num;
            res[i++] = -1 * num;
            num++;
        }
        return res;
    }
}
