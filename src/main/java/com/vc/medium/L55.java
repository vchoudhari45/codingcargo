package com.vc.medium;

class L55 {
    public boolean canJump(int[] arr) {
        int n = arr.length;
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(max < i) return false;
            max = Math.max(max, arr[i] + i);
        }
        return true;
    }
}
