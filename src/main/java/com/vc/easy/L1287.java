package com.vc.easy;

class L1287 {
    public int findSpecialInteger(int[] arr) {
        int fourth = arr.length / 4 + 1;
        int res = -1;
        //System.out.println(fourth);
        for(int i = 0; i < arr.length;) {
            int prev = arr[i];
            int old = i;
            while(i < arr.length && arr[i] == prev) i++;
            if(i - old >= fourth) return prev;
        }
        return res;
    }
}
