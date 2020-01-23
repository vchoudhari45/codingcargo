package com.vc.medium;

class L334 {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for(int n: nums) {
            if(small >= n) small = n;
            else if(big >= n) big = n;
            else return true;
        }
        return false;
    }
}
