package com.vc.medium;

class L668 {
    public int[] constructArray(int n, int k) {
        /**

             Idea is to keep using left & right alternatively, but once we have k == 1
             i.e. we have accepted number of difference between the seq = 1,
             just keep on increasing left value so that we only get difference as 1

             for e.g.
                 10
                 3
                 [1,10,2,3,4,5,6,7,8,9]

             for 0th index took left  1
             for 1th index took right 10, difference = 9 reduce k to 2
             for 2nd index took left  2,  difference = 8 reduce k to 1
             Now our sequence can have only one different number as difference between two consecutive values
             so only keep on increasing left
         */
        int[] res = new int[n];
        int left = 1, right = n;
        for(int i = 0; i < n; i++){
            res[i] = k % 2 != 0 ? left++ : right--;
            if(k > 1) k--;
        }
        return res;
    }
}